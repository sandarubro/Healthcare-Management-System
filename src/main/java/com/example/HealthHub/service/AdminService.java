package com.example.HealthHub.service;

import com.example.HealthHub.model.Admin;
import com.example.HealthHub.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin) {
        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        return adminRepository.save(admin);
    }
}
