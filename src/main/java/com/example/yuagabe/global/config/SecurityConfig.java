package com.example.yuagabe.global.config;

import com.example.yuagabe.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                // user
                .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/users/signin").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users/nickname").authenticated()
                .antMatchers(HttpMethod.PATCH, "/users/information").authenticated()
                .antMatchers(HttpMethod.GET, "/users/user").authenticated()

                // feed
                .antMatchers(HttpMethod.POST, "/feeds").authenticated()
                .antMatchers(HttpMethod.DELETE, "/feeds/{feed-id}").authenticated()
                .antMatchers(HttpMethod.GET, "/feeds").authenticated()
                .antMatchers(HttpMethod.GET, "/feeds/{feed-id}").authenticated()
                .antMatchers(HttpMethod.PATCH, "/feeds").authenticated()

                .and()
                .apply(new FilterConfig(jwtTokenProvider, objectMapper))

                .and().build();
    }

    @Bean
    public HttpFirewall httpFirewall() {
        return new DefaultHttpFirewall();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
