package com.careem.ordersservicekafka.controllers;

import com.careem.ordersservicekafka.dto.OrderKafkaMessage;
import com.careem.ordersservicekafka.dto.PayOrderRequest;
import com.careem.ordersservicekafka.dto.PayOrderResponse;
import com.careem.ordersservicekafka.services.OrderService;
import com.careem.ordersservicekafka.utils.OrderPaymentConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Value("${orders.topic.name}")
    private String ordersTopicName;

    private OrderService orderService;
    private KafkaTemplate<String, String> kafkaTemplate;

    public OrderController(OrderService orderService, KafkaTemplate<String, String> kafkaTemplate) {
        this.orderService = orderService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PutMapping
    public ResponseEntity<?> payOrder(@RequestBody PayOrderRequest request){
        PayOrderResponse response = orderService.payOrder(request);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody PayOrderRequest request){
        kafkaTemplate.send(ordersTopicName, OrderPaymentConverter.convertOrderToOrderMessage(request).toString());
        return ResponseEntity.status(201).body(request);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<?> handleWebClientResponseException(WebClientResponseException e){
        return ResponseEntity.status(e.getRawStatusCode()).body(e.getResponseBodyAsString());
    }

    @ExceptionHandler(WebClientRequestException.class)
    public ResponseEntity<?> handleWebClientRequestException(WebClientRequestException e){
        return ResponseEntity.status(200).body(e.getMessage());
    }
}
