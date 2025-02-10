package com.example.yuagabe.global.security.auth.domain.repository;


import com.example.yuagabe.global.security.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    RefreshToken findByRefreshToken(String refreshToken);
}