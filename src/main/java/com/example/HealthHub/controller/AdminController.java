package com.example.HealthHub.controller;

import com.example.HealthHub.dto.AdminLoginDto;
import com.example.HealthHub.model.Admin;
import com.example.HealthHub.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(
            @PathVariable Long id,
            @RequestBody Admin adminDetails) {
        return ResponseEntity.ok(adminService.updateAdmin(id, adminDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginDto adminLoginDto) {
        try {
            Admin admin = adminService.authenticateAdmin(
                    adminLoginDto.getEmail(),
                    adminLoginDto.getPassword()
            );
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", e.getMessage()));
        }
    }


}