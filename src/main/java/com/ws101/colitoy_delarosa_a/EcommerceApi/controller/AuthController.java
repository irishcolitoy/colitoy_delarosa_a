package com.ws101.colitoy_delarosa_a.EcommerceApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.ws101.colitoy_delarosa_a.EcommerceApi.dto.LoginRequest;
import com.ws101.colitoy_delarosa_a.EcommerceApi.dto.LoginResponse;
import com.ws101.colitoy_delarosa_a.EcommerceApi.model.User;
import com.ws101.colitoy_delarosa_a.EcommerceApi.repository.UserRepository;
import com.ws101.colitoy_delarosa_a.EcommerceApi.service.JwtUtil;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        User user = userRepository
                .findByUsername(loginRequest.getUsername())
                .orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(
                loginRequest.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new LoginResponse(token);
    }
}