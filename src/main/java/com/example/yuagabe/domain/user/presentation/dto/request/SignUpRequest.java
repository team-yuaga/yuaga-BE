package com.example.yuagabe.domain.user.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignUpRequest {
    @NotBlank
    @Size(max = 15 , message = "아이디는 최대 15자까지 허용입니다.")
    @JsonProperty("accountId")
    private String accountId;

    @NotBlank
    @Size(min = 8, max = 20, message = "비밀번호는 최소 8자 ~ 20자까지 허용입니다.")
    private String password;

    @NotBlank
    @Size(min = 8, max = 20, message = "비밀번호는 최소 8자 ~ 20자까지 허용입니다.")
    @JsonProperty("checkPassword")
    private String checkPassword;

    @NotBlank
    @Size(max = 10 , message = "닉네임은 최대 10자까지 허용입니다.")
    private String nickname;
}
