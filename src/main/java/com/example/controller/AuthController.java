package com.example.controller;

import com.example.service.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            return jwtUtil.generateToken(username);
        } else {
            return "Invalid credentials";
        }
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "Access granted to secure endpoint.";
    }
}
