package com.example.voteX.service;



import com.example.voteX.model.User;
import com.example.voteX.repository.UserRepository;
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