package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.Service.AuditLogService;
import com.wms.warehouse_management_system.jwt.JwtUtil;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder;

    private final AuditLogService auditLogService;

    public AuthController(
            JwtUtil jwtUtil,
            BCryptPasswordEncoder passwordEncoder,
            AuditLogService auditLogService) {

        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.auditLogService = auditLogService;
    }

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String username,
            @RequestParam String role) {

        Map<String, String> response =
                new HashMap<>();

        String accessToken =
                jwtUtil.generateToken(
                        username,
                        role
                );

        String refreshToken =
                jwtUtil.generateRefreshToken(
                        username
                );

        response.put(
                "accessToken",
                accessToken
        );

        response.put(
                "refreshToken",
                refreshToken
        );

        auditLogService.saveLog(
                username,
                "LOGIN"
        );

        return response;
    }

    @PostMapping("/refresh")
    public String refreshToken(
            @RequestParam String refreshToken) {

        return "Refresh Token Working";
    }

    @PostMapping("/encrypt")
    public String encryptPassword(
            @RequestParam String password) {

        return passwordEncoder.encode(
                password
        );
    }

    @PostMapping("/verify")
    public boolean verifyPassword(
            @RequestParam String password,
            @RequestParam String hash) {

        return passwordEncoder.matches(
                password,
                hash
        );
    }
}