package com.careem.paymentservicekafka.listeners;

import com.careem.paymentservicekafka.dto.OrderKafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrdersTopicListener {

    private static final String ORDERS_TOPIC_NAME = "orders-topic";

    @KafkaListener(topics = ORDERS_TOPIC_NAME, groupId = "groupId", containerFactory = "factory")
    void listener(String orderMessage){
        System.out.println(orderMessage);
    }
}
