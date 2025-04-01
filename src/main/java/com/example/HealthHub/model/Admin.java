package com.example.HealthHub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "admin")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;  // Field name must be lowercase

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;
}