package com.careem.orderservicehttp.services;

import com.careem.orderservicehttp.dao.PaymentClient;
import com.careem.orderservicehttp.dto.OrderPaymentResponse;
import com.careem.orderservicehttp.dto.PayOrderRequest;
import com.careem.orderservicehttp.dto.PayOrderResponse;
import com.careem.orderservicehttp.utils.OrderPaymentConverter;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private PaymentClient paymentClient;

    public OrderService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public PayOrderResponse payOrder(PayOrderRequest order){
        OrderPaymentResponse response = paymentClient.payOrder(OrderPaymentConverter.convertOrderToPayment(order));
        return OrderPaymentConverter.convertPaymentToOrder(response);
    }
}
