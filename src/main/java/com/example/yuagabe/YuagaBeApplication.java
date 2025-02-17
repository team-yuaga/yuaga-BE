package com.example.yuagabe;

import com.example.yuagabe.global.security.jwt.JwtProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperty.class)
public class YuagaBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuagaBeApplication.class, args);
    }

}
