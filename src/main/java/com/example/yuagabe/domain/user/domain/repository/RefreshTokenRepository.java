package com.example.yuagabe.domain.user.domain.repository;

import com.example.yuagabe.domain.user.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    RefreshToken findByRefreshToken(String refreshToken);
}