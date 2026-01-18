package com.payment.app.service;

import org.springframework.stereotype.Service;
import com.payment.app.model.BankResult;
import com.payment.app.model.PaymentResult;

@Service
public class PaymentService {

    private final BankService bankService;

    public PaymentService(BankService bankService) {
        this.bankService = bankService;
    }

    public PaymentResult processPayment(String orderId, double amount) {

        int attempt = 1;
        int maxAttempt = 3;

        while(attempt <= maxAttempt){
            BankResult bankResult = bankService.debit(orderId, amount);

            if (bankResult == BankResult.SUCCESS) {
                return PaymentResult.SUCCESS;
            }

            if (bankResult == BankResult.PENDING) {
                return PaymentResult.PENDING;
            }
            attempt++;
        }

        return PaymentResult.FAILED;
    }
}
