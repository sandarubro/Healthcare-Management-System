package com.example.HealthHub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "doctor")
@Data

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    // Getters and Setters
}
