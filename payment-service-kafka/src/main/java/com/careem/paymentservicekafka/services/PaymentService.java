package com.careem.paymentservicekafka.services;

import com.careem.paymentservicekafka.dto.CreatePaymentRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    public CreatePaymentRequest createPayment(CreatePaymentRequest payment){
        UUID paymentNumber = UUID.randomUUID();
        payment.setStatus("paid");
        payment.setPaymentNumber(paymentNumber.toString());
        return payment;
    }
}
