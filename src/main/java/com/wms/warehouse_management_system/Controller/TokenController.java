package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.jwt.JwtUtil;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/token")

public class TokenController {

    private final JwtUtil jwtUtil;

    public TokenController(
            JwtUtil jwtUtil)
    {
        this.jwtUtil=
                jwtUtil;
    }

    @GetMapping("/validate")

    public boolean validate(

            @RequestParam String token)
    {

        return jwtUtil
                .validateToken(
                        token
                );

    }

}