package com.example.HealthHub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "patient")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Patient_ID")
    private Long patientId;

    @Column(name = "Patient_Name", nullable = false)
    private String patientName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Phone_Number", nullable = false)
    private String phoneNumber;

    @Column(name = "Age", nullable = false)
    private String age;

    @Column(name = "Gender", nullable = false)
    private String gender;

    @Column(name = "Blood_Group", nullable = false)
    private String bloodGroup;
}
