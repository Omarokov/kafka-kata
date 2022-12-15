package com.careem.orderservicehttp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PaymentClientConfig {

    @Value("${payment.url}")
    private String paymentUrl;
    @Value("${service.name}")
    private String orderServiceName;

    @Bean
    public WebClient createPaymentClient(){
        return WebClient.builder()
                .baseUrl(paymentUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, orderServiceName)
                .build();
    }
}
