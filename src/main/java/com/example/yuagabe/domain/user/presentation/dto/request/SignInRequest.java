package com.example.yuagabe.domain.user.presentation.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignInRequest {
    @NotBlank
    @Size(max = 15, message = "아이디는 최대 15자까지 허용입니다.")
    private String accountId;

    @NotBlank
    @Size(max = 20, message = "비밀번호는 최소 8자 ~ 20자까지 허용합니다.")
    private String password;
}
