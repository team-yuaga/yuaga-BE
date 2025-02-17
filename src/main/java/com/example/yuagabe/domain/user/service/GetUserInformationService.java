package com.example.yuagabe.domain.user.service;


import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import com.example.yuagabe.domain.user.presentation.dto.response.UserInformationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GetUserInformationService {
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public UserInformationResponse execute() {
        User user = userFacade.getCurrentUser();
        return new UserInformationResponse(user.getNickName(), user.getHeight(), user.getWeight(), user.getSkin(), user.getStyle(), user.getUserPersonalColor());
    }
}
