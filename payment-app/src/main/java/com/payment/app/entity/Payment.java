package com.payment.app.entity;

import com.payment.app.model.PaymentResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String orderId;

    private Long userId;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentResult status;

    private int attempts;

    private LocalDateTime createdAt;
}
