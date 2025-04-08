package com.example.HealthHub.repository;

import com.example.HealthHub.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Method name must match entity field name (email)
    boolean existsByEmail(String email);
}
