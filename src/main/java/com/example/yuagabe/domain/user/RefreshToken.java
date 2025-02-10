package com.example.yuagabe.domain.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "refreshToken", timeToLive = 604800)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class RefreshToken{
    @Id
    private String accountId;
    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long expiration;

    public void updateToken(String refreshToken, Long expiration){
        this.refreshToken = refreshToken;
        this.expiration = expiration;
    }
}