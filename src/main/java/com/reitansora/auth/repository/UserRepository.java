package com.reitansora.auth.repository;

import com.reitansora.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

    Optional<UserEntity> findByUserId(String userId);

    /**
     * Checks if a user exists by their userId.
     *
     * @param userId the userId to check
     * @return true if user exists, false otherwise
     */
    Boolean existsByUserId(String userId);

}
