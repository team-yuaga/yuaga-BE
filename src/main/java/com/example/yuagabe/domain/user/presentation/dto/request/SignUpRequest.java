package com.example.yuagabe.domain.user.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class SignUpRequest {
    @NotBlank
    @Size(max = 15 , message = "아이디는 최대 15자까지 허용입니다.")
    private final String accountId;

    @NotBlank
    @Size(min = 8, max = 20, message = "비밀번호는 최소 8자 ~ 20자까지 허용입니다.")
    private final String password;

    @NotBlank
    @Size(min = 8, max = 20, message = "비밀번호는 최소 8자 ~ 20자까지 허용입니다.")
    private final String checkPassword;

    @NotBlank
    @Size(max = 10 , message = "닉네임은 최대 10자까지 허용입니다.")
    private final String nickname;
}
