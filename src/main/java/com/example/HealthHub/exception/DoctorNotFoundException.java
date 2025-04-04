package com.example.HealthHub.exception;

public class DoctorNotFoundException extends RuntimeException {
  public DoctorNotFoundException(String message) {
    super(message);
  }
}
