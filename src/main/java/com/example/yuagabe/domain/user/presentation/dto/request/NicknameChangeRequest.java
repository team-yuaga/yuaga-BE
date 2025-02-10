package com.example.yuagabe.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class NicknameChangeRequest {

    @NotBlank
    @Size(max = 10, message = "닉네임은 최대 10자까지 허용입니다.")
    private String nickname;
}
