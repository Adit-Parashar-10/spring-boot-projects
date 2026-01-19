package com.payment.app.service;

import com.payment.app.dto.PaymentResponseDTO;
import com.payment.app.entity.Payment;
import com.payment.app.exception.InvalidPaymentException;
import com.payment.app.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.payment.app.model.BankResult;
import com.payment.app.model.PaymentResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private final BankService bankService;
    private final PaymentRepository paymentRepository;

    public PaymentService(BankService bankService, PaymentRepository paymentRepository) {
        this.bankService = bankService;
        this.paymentRepository=paymentRepository;
    }

    @Transactional
    public PaymentResult processPayment(String orderId, double amount, Long userId) {

        if(orderId == null || orderId.isBlank()){
            throw new InvalidPaymentException("order can't be null");
        }

        if(amount < 0){
            throw new InvalidPaymentException("amount can't be negative");
        }

        int attempt = 1;
        int maxAttempt = 3;

        PaymentResult finalRes = PaymentResult.FAILED;

        while(attempt <= maxAttempt){
            BankResult bankResult = bankService.debit(orderId, amount);

            if (bankResult == BankResult.SUCCESS) {
                finalRes = PaymentResult.SUCCESS;
                break;
            }

            if (bankResult == BankResult.PENDING) {
                finalRes = PaymentResult.PENDING;;
                break;
            }
            attempt++;
        }

        Payment payment = new Payment();

        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setUserId(userId);
        payment.setAttempts(attempt);
        payment.setStatus(finalRes);
        payment.setCreatedAt(LocalDateTime.now());

        paymentRepository.save(payment);

        return finalRes;
    }

    @Transactional
    public List<PaymentResponseDTO> getAllPayments(){

        List<Payment> res = paymentRepository.findAll();
        List<PaymentResponseDTO> dto = new ArrayList<>();

        for(Payment payment : res){

            PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO(payment.getOrderId(), payment.getStatus().name());

            dto.add(paymentResponseDTO);
        }
        return dto;
    }

    @Transactional
    public PaymentResponseDTO getPayments(String orderId){

        Payment payment = paymentRepository.findByOrderId(orderId).orElseThrow(() -> new RuntimeException("couldn't find order !!!"));

        return new PaymentResponseDTO(payment.getOrderId(), payment.getStatus().name());
    }

    @Transactional
    public List<PaymentResponseDTO> getPaymentsByUser(Long userId) {

        List<Payment> payments = paymentRepository.findByUserId(userId);

        List<PaymentResponseDTO> response = new ArrayList<>();

        for (Payment payment : payments) {
            response.add(new PaymentResponseDTO(payment.getOrderId(), payment.getStatus().name()));
        }
        return response;
    }

    @Transactional
    public List<PaymentResponseDTO> getPaymentsByStatus(String status) {

        PaymentResult st = PaymentResult.valueOf(status.toUpperCase());
        List<Payment> payments = paymentRepository.findByStatus(st);

        List<PaymentResponseDTO> res = new ArrayList<>();

        for (Payment p : payments) {
            res.add(new PaymentResponseDTO(
                    p.getOrderId(),
                    p.getStatus().name()
            ));
        }
        return res;
    }





}
