package com.example.HealthHub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Appointment_ID")
    private Long appointmentId;

    @Column(name = "Patient_Name", nullable = false)
    private String patientName;

    @Column(name = "Doctor_Name", nullable = false)
    private String doctorName;

    @Column(name = "Time", nullable = false)
    private String time;

    @Column(name = "Age", nullable = false)
    private String age;

    @Column(name = "Date", nullable = false)
    private String date;
}
