package com.payment.app.controller;

import com.payment.app.dto.PaymentRequestDTO;
import com.payment.app.dto.PaymentResponseDTO;
import com.payment.app.model.PaymentResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.payment.app.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/v1/pay")
    public ResponseEntity<PaymentResponseDTO> pay(@RequestBody PaymentRequestDTO dto) {
        PaymentResult st = paymentService.processPayment(dto.getOrderId(), dto.getAmount());
        PaymentResponseDTO res = new PaymentResponseDTO(dto.getOrderId(), st.name());
        return ResponseEntity.ok(res);
    }
}
