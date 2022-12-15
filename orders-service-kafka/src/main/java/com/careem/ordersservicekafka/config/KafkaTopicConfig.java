package com.careem.ordersservicekafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${orders.topic.name}")
    private String ordersTopicName;
    @Bean
    public NewTopic ordersTopic(){
        return TopicBuilder.name(ordersTopicName).build();
    }
}
