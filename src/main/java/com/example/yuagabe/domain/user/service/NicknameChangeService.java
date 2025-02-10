package com.example.yuagabe.domain.user.service;

import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import com.example.yuagabe.domain.user.presentation.dto.request.NicknameChangeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NicknameChangeService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(NicknameChangeRequest request) {
        User user = userFacade.getCurrentUser();

        user.changeNickname(request.getNickname());
    }
}
