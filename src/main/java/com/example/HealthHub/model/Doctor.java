package com.example.HealthHub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "doctor")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Doctor_ID")
    private Long doctorId;

    @Column(name = "Specialization", nullable = false)
    private String specialization;

    @Column(name = "Doctor_Name", nullable = false)
    private String doctorName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;  // Field name must be lowercase

    @Column(name = "Phone_Number", nullable = false)
    private String phoneNumber;


}