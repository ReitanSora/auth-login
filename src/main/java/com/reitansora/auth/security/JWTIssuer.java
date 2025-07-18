package com.reitansora.auth.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public class JWTIssuer {

    private final JwtProperties properties;

    public String issue(String userId, String email, String planName, Long maxBitrate,Timestamp createdAt) {
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withClaim("email", email)
                .withClaim("planName", planName)
                .withClaim("maxBitrate", maxBitrate)
                .withClaim("createdAt", createdAt)
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plus(Duration.of(7, ChronoUnit.DAYS)))
                .sign(Algorithm.HMAC256(properties.getSecretKey()));
    }
}
