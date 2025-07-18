package com.reitansora.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

/**
 * Represents a user entity in the database.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity {

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The user ID.
     */
    @Column(unique = true)
    private String userId;

    /**
     * The user's email.
     */
    @Column
    private String email;

    /**
     * The user's password.
     */
    @Column
    private String password;

    private Boolean isAccountVerified;
    private String verifyOtp;
    private Long verifyOtpExpireAt;
    private String resetOtp;
    private Long resetOtpExpireAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "plan_id",
            referencedColumnName = "id",
            nullable = false
    )
    private PlanEntity plan;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "profile_id",
            referencedColumnName = "id"
    )
    private ProfileEntity profile;

    /**
     * The timestamp when the user was created.
     */
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    /**
     * The timestamp when a user is modified.
     */
    @UpdateTimestamp
    private Timestamp updatedAt;

}
