package com.payment.app.controller;

import com.payment.app.dto.PaymentRequestDTO;
import com.payment.app.dto.PaymentResponseDTO;
import com.payment.app.model.PaymentResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.payment.app.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class UserPaymentController {

    private final PaymentService paymentService;

    public UserPaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/v1/{orderId}")
    public ResponseEntity<PaymentResponseDTO> getPaymentStatus(
            @PathVariable String orderId) {
        return ResponseEntity.ok(paymentService.getPayments(orderId));
    }

    @PostMapping("/v1/pay")
    public ResponseEntity<PaymentResponseDTO> pay(@RequestBody PaymentRequestDTO dto) {
        PaymentResult st = paymentService.processPayment(dto.getOrderId(), dto.getAmount(), dto.getUserId());
        PaymentResponseDTO res = new PaymentResponseDTO(dto.getOrderId(), st.name());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/v1/{userId}")
    public ResponseEntity<List<PaymentResponseDTO>> getUserPayments(@RequestParam Long userId) {
        return ResponseEntity.ok(paymentService.getPaymentsByUser(userId));
    }



}
