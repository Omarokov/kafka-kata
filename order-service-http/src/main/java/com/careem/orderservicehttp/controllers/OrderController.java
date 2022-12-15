package com.careem.orderservicehttp.controllers;

import com.careem.orderservicehttp.dto.PayOrderRequest;
import com.careem.orderservicehttp.dto.PayOrderResponse;
import com.careem.orderservicehttp.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PutMapping
    public ResponseEntity<?> payOrder(@RequestBody PayOrderRequest request){
        PayOrderResponse response = orderService.payOrder(request);
        return ResponseEntity.status(200).body(response);
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
