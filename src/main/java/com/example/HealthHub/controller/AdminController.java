package com.example.HealthHub.controller;

import com.example.HealthHub.model.Admin;
import com.example.HealthHub.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok(savedAdmin);
    }
}
