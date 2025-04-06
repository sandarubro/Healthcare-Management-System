package com.example.HealthHub.repository;

import com.example.HealthHub.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Method name must match entity field name (email)
    boolean existsByEmail(String email);
}