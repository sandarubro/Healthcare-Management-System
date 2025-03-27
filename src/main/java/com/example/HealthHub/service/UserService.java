package com.example.HealthHub.service;



import com.example.HealthHub.model.User;
import com.example.HealthHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        // Add validation logic here (e.g., check if username/email already exists)
        userRepository.save(user);
    }
}