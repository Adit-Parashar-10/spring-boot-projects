package com.payment.app.controller;

import com.payment.app.dto.PaymentResponseDTO;
import com.payment.app.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/payments")
public class AdminController {

    private final PaymentService paymentService;


    public AdminController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("{orderId}")
    public ResponseEntity<PaymentResponseDTO> getPayment(@PathVariable String orderId){
        return ResponseEntity.ok(paymentService.getPayments(orderId));
    }
}
