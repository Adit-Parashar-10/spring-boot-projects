package com.payment.app.service;

import com.payment.app.model.BankResult;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    public BankResult debit(String orderID, double amt) {

        if (amt <= 1000) {
            return BankResult.SUCCESS;
        } else if (amt <= 2000) {
            return BankResult.PENDING;
        } else {
            return BankResult.FAILED;
        }
    }
}
