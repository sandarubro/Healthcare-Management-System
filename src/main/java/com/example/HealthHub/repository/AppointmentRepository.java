package com.example.HealthHub.repository;

import com.example.HealthHub.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppointmentId(Long appointmentId);

}
