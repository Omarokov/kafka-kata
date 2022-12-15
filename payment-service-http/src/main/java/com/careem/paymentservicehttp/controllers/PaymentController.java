package com.careem.paymentservicehttp.controllers;

import com.careem.paymentservicehttp.dto.CreatePaymentRequest;
import com.careem.paymentservicehttp.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody CreatePaymentRequest request){
        CreatePaymentRequest response = paymentService.createPayment(request);
        return ResponseEntity.status(201).body(response);
    }
}
