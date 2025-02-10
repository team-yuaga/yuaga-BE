package com.example.yuagabe.domain.user.service;

import com.example.yuagabe.domain.user.User;
import com.example.yuagabe.domain.user.exception.PasswordMisMatchException;
import com.example.yuagabe.domain.user.presentation.dto.request.SignUpRequest;
import com.example.yuagabe.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest signUpRequest) {
        if (userRepository.findByAccountId(signUpRequest.getAccountId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 존재하는 " + signUpRequest.getAccountId() + " 아이디 입니다.");
        }
        if (!signUpRequest.getPassword().equals(signUpRequest.getCheckPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        userRepository.save(User.builder()
                .accountId(signUpRequest.getAccountId())
                .password(encodedPassword)
                .nickName(signUpRequest.getNickname())
                .build());
    }
}
