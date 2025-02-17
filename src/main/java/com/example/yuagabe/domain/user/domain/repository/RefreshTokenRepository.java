package com.example.yuagabe.domain.user.domain.repository;

import com.example.yuagabe.domain.user.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    RefreshToken findByRefreshToken(String refreshToken);
}