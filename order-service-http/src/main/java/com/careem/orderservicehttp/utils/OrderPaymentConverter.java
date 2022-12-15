package com.careem.orderservicehttp.utils;

import com.careem.orderservicehttp.dto.OrderPaymentRequest;
import com.careem.orderservicehttp.dto.OrderPaymentResponse;
import com.careem.orderservicehttp.dto.PayOrderRequest;
import com.careem.orderservicehttp.dto.PayOrderResponse;

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
}
