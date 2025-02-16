package com.example.yuagabe.domain.user.service;


import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import com.example.yuagabe.domain.user.presentation.dto.request.UserInformationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserInformationService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(UserInformationRequest request) {
        User user = userFacade.getCurrentUser();

        user.UserInformation(request.getHeight(), request.getWeight(), request.getSkin(), request.getStyle(), request.getUserPersonalColor());
    }
}
