package com.example.HealthHub.service;

import com.example.HealthHub.exception.DoctorNotFoundException;
import com.example.HealthHub.model.Doctor;
import com.example.HealthHub.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(Doctor doctor) {
        if (doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        return doctorRepository.save(doctor); // No password encoding
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id));
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id));

        // Update fields without password encoding
        doctor.setDoctorName(doctorDetails.getDoctorName());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setPhoneNumber(doctorDetails.getPhoneNumber());
        doctor.setSpecialization(doctorDetails.getSpecialization());


        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));
        doctorRepository.delete(doctor);
    }
}