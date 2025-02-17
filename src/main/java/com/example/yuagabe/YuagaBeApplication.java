package com.example.yuagabe;

import com.example.yuagabe.global.security.jwt.JwtProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableConfigurationProperties(JwtProperty.class)
public class YuagaBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuagaBeApplication.class, args);
    }

}
