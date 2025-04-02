package com.example.HealthHub.controller;

import com.example.HealthHub.model.Doctor;
import com.example.HealthHub.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
@CrossOrigin

public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setDoctorName(doctorDetails.getDoctorName());
            doctor.setEmail(doctorDetails.getEmail());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            doctor.setPhoneNumber(doctorDetails.getPhoneNumber());
            doctor.setPassword(doctorDetails.getPassword());
            return doctorRepository.save(doctor);
        }).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }
}
