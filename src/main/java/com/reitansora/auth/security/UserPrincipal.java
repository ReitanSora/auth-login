package com.reitansora.auth.security;

import com.reitansora.auth.entity.PlanEntity;
import com.reitansora.auth.entity.ProfileEntity;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Getter
@Builder
public class UserPrincipal implements UserDetails {

    private final Long id;
    private final String userId;
    private final String email;
    private final String password;
    private final Boolean isAccountVerified;
    private final String verifyOtp;
    private final Long verifyOtpExpireAt;
    private final String resetOtp;
    private final Long resetOtpExpireAt;
    private final PlanEntity plan;
    private final ProfileEntity profile;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
