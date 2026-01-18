package com.payment.app.service;

import com.payment.app.dto.SignupRequestDTO;
import com.payment.app.entity.User;
import com.payment.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(SignupRequestDTO dto) {

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // abhi plain (hash later)
        user.setRole("USER");

        return userRepository.save(user);
    }
}

