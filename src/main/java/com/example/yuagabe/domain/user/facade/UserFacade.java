package com.example.yuagabe.domain.user.facade;

import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.domain.repository.UserRepository;
import com.example.yuagabe.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByAccountId(accountId);
    }

    public User getUserByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
