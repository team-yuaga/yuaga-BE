package com.example.yuagabe.domain.user.presentation.dto.response;


import com.example.yuagabe.domain.user.domain.UserPersonalColor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInformationResponse {
    private final String nickName;
    private final Long height;
    private final Long weight;
    private final String skin;
    private final String style;
    private final UserPersonalColor userPersonalColor;

    public UserInformationResponse(String nickName, Long height, Long weight,
                                   String skin, String style, UserPersonalColor userPersonalColor) {
        this.nickName = nickName;
        this.height = height;
        this.weight = weight;
        this.skin = skin;
        this.style = style;
        this.userPersonalColor = userPersonalColor;
    }
}
