package com.example.yuagabe.domain.user.presentation.dto.request;

import com.example.yuagabe.domain.user.domain.UserPersonalColor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInformationRequest {

    private String height;

    private String weight;

    private String skin;

    private String style;

    private UserPersonalColor userPersonalColor;
}
