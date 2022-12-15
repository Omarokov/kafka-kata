package com.careem.orderservicehttp.dao;

import com.careem.orderservicehttp.dto.OrderPaymentRequest;
import com.careem.orderservicehttp.dto.OrderPaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentClient {

    @Value("${payment.order.endpoint}")
    private String paymentEndpoint;
    private WebClient paymentWebclient;

    public PaymentClient(WebClient paymentWebclient) {
        this.paymentWebclient = paymentWebclient;
    }

    public OrderPaymentResponse payOrder(OrderPaymentRequest request){
        return paymentWebclient
                .post()
                .uri(paymentEndpoint)
                .body(Mono.just(request), OrderPaymentRequest.class)
                .retrieve()
                .bodyToMono(OrderPaymentResponse.class)
                .block();
    }
}
