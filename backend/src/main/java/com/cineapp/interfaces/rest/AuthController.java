package com.cineapp.interfaces.rest;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineapp.application.dto.LoginRequestDTO;
import com.cineapp.infrastructure.config.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequestDTO request) {

        if (!"admin".equals(request.getUsername()) ||
            !"1234".equals(request.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtUtil.generateToken(request.getUsername());

        return Map.of("token", token);
    }
}