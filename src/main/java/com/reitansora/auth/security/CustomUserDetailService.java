package com.reitansora.auth.security;

import com.reitansora.auth.entity.UserEntity;
import com.reitansora.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Find user in your repository
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow();

        // Return UserPrincipal instead of User
        return UserPrincipal.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .email(user.getEmail())
                .password(user.getPassword())
                .isAccountVerified(user.getIsAccountVerified())
                .verifyOtp(user.getVerifyOtp())
                .verifyOtpExpireAt(user.getVerifyOtpExpireAt())
                .resetOtp(user.getResetOtp())
                .resetOtpExpireAt(user.getResetOtpExpireAt())
                .plan(user.getPlan())
                .profile(user.getProfile())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();

    }
}
