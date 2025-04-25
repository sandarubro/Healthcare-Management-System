package com.example.HealthHub.repository;

import com.example.HealthHub.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Method name must match entity field name (transactionId)
    boolean existsByPaymentId(Long paymentId);
}
