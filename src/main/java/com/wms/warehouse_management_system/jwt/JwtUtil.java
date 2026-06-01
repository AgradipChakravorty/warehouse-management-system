package com.wms.warehouse_management_system.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY =
            "myverysecuresecretkeyforjwtauthentication123456";

    // Generate token
    public String generateToken(
            String username,
            String role)
    {

        return Jwts.builder()

                .setSubject(
                        username
                )

                .claim(
                        "role",
                        role
                )

                .setIssuedAt(
                        new Date()
                )

                .setExpiration(

                        new Date(

                                System.currentTimeMillis()

                                        +3600000
                        )
                )

                .signWith(

                        SignatureAlgorithm.HS256,

                        SECRET_KEY
                )

                .compact();

    }

    // Validate token
    public boolean validateToken(
            String token)
    {

        try
        {

            Jwts.parser()

                    .setSigningKey(
                            SECRET_KEY
                    )

                    .parseClaimsJws(
                            token
                    );

            return true;

        }

        catch(Exception e)
        {

            return false;

        }

    }

    // Extract claims
    public Claims extractClaims(
            String token)
    {

        return Jwts.parser()

                .setSigningKey(
                        SECRET_KEY
                )

                .parseClaimsJws(
                        token
                )

                .getBody();
    }

    public String generateRefreshToken(
            String username)
    {

        return Jwts.builder()

                .setSubject(username)

                .setIssuedAt(
                        new Date()
                )

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 604800000
                        )
                )

                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET_KEY
                )

                .compact();
    }
}