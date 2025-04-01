package com.example.HealthHub.repository;

import com.example.HealthHub.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Method name must match entity field name (email)
    boolean existsByEmail(String email);
}