package com.careem.ordersservicekafka.utils;

import com.careem.ordersservicekafka.dto.OrderKafkaMessage;
import com.careem.ordersservicekafka.dto.OrderPaymentRequest;
import com.careem.ordersservicekafka.dto.OrderPaymentResponse;
import com.careem.ordersservicekafka.dto.PayOrderRequest;
import com.careem.ordersservicekafka.dto.PayOrderResponse;

public class OrderPaymentConverter {

    public static OrderPaymentRequest convertOrderToPayment(PayOrderRequest request){
        OrderPaymentRequest temp = new OrderPaymentRequest();
        temp.setOrderNumber(request.getOrderNumber());
        temp.setPrice(request.getPrice());
        temp.setItemsNumber(request.getItemsNumber());
        temp.setStatus(request.getStatus());
        return temp;
    }

    public static PayOrderResponse convertPaymentToOrder(OrderPaymentResponse response){
        PayOrderResponse temp = new PayOrderResponse();
        temp.setOrderNumber(response.getOrderNumber());
        temp.setPaymentNumber(response.getPaymentNumber());
        temp.setItemsNumber(response.getItemsNumber());
        temp.setPrice(response.getPrice());
        temp.setStatus(response.getStatus());
        return temp;
    }

    public static OrderKafkaMessage convertOrderToOrderMessage(PayOrderRequest request){
        OrderKafkaMessage temp = new OrderKafkaMessage();
        temp.setOrderNumber(request.getOrderNumber());
        temp.setItemsNumber(request.getItemsNumber());
        temp.setPrice(request.getPrice());
        temp.setStatus(request.getStatus());
        return temp;
    }
}
