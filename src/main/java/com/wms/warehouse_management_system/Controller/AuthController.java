package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.jwt.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
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

        return response;
    }

    @PostMapping("/refresh")
    public String refreshToken(
            @RequestParam String refreshToken) {

        return "Refresh Token Working";
    }
}