package com.reitansora.auth.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Component
public class JwtToPrincipalConverter {
    public UserPrincipal convert(DecodedJWT decodedJWT) {
        return UserPrincipal.builder()
                .userId(String.valueOf(decodedJWT.getSubject()))
                .email(decodedJWT.getClaim("email").asString())
                .createdAt(getCreatedAtTimestamp(decodedJWT))
                .build();
    }

    private Timestamp getCreatedAtTimestamp(DecodedJWT decodedJWT) {
        String createdAtStr = decodedJWT.getClaim("createdAt").asString();
        if (createdAtStr == null || createdAtStr.isEmpty()) {
            // If createdAt is not present, use current timestamp
            return new Timestamp(Instant.now().toEpochMilli());
        }
        return Timestamp.valueOf(createdAtStr);
    }

    private List<SimpleGrantedAuthority> getAuthorities(DecodedJWT decodedJWT) {
        var claim = decodedJWT.getClaim("authorities");
        if (claim.isNull() || claim.isMissing()) return List.of();
        return claim.asList(SimpleGrantedAuthority.class);
    }

}
