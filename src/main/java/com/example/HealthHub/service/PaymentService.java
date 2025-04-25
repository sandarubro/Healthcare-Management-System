package com.example.HealthHub.service;

import com.example.HealthHub.exception.PaymentNotFoundException;
import com.example.HealthHub.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + id));
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + id));

        // Update fields
        payment.setDate(paymentDetails.getDate());
        payment.setTotalAmount(paymentDetails.getTotalAmount());
        payment.setPatientName(paymentDetails.getPatientName());
        payment.setDoctorName(paymentDetails.getDoctorName());

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found"));
        paymentRepository.delete(payment);
    }
}
