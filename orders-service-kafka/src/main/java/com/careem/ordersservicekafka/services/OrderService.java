package com.careem.ordersservicekafka.services;

import com.careem.ordersservicekafka.dao.PaymentClient;
import com.careem.ordersservicekafka.dto.OrderPaymentResponse;
import com.careem.ordersservicekafka.dto.PayOrderRequest;
import com.careem.ordersservicekafka.dto.PayOrderResponse;
import com.careem.ordersservicekafka.utils.OrderPaymentConverter;
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
