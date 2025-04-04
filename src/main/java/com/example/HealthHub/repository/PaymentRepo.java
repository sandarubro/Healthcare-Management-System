package com.example.HealthHub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment_ID")
    private Long paymentId;

    @Column(name = "Patient_Name", nullable = false)
    private String patientName;

    @Column(name = "Doctor_Name", nullable = false)
    private String doctorName;

    @Column(name = "Total_Amount", nullable = false, unique = true)
    private String totalAmount;

    @Column(name = "Date", nullable = false)
    private String date;
}
