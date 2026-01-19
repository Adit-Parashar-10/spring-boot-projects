package com.payment.app.repository;

import com.payment.app.entity.Payment;
import com.payment.app.model.PaymentResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findByOrderId(String orderId);
    List<Payment> findByStatus(PaymentResult status);
    List<Payment> findByUserId(Long userId);
}
