package com.xideral.auth.auth_service.controller;

import com.xideral.auth.auth_service.dto.AuthRequest;
import com.xideral.auth.auth_service.utils.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        if ("admin".equals(authRequest.getUser()) && "password".equals(authRequest.getPassword())) {
            return jwtTokenProvider.generateToken(authRequest.getUser(), "ADMIN");
        }
        throw new RuntimeException("Credenciales inválidas");
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestParam String token) {
        try {
            jwtTokenProvider.validateToken(token);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.ok(Boolean.FALSE);
        }
    }
}