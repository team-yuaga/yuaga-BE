package com.example.yuagabe.domain.user.presentation;

import com.example.yuagabe.domain.user.presentation.dto.request.NicknameChangeRequest;
import com.example.yuagabe.domain.user.presentation.dto.request.SignInRequest;
import com.example.yuagabe.domain.user.presentation.dto.request.SignUpRequest;
import com.example.yuagabe.domain.user.presentation.dto.response.TokenResponse;
import com.example.yuagabe.domain.user.service.NicknameChangeService;
import com.example.yuagabe.domain.user.service.SignInService;
import com.example.yuagabe.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final SignUpService signUpService;
    private final SignInService signInService;
    private final NicknameChangeService nicknameChangeService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return signInService.execute(request);
    }

    @PatchMapping("/nickname")
    @ResponseStatus(HttpStatus.OK)
    public void nickname(@RequestBody @Valid NicknameChangeRequest request){
        nicknameChangeService.execute(request);
    }
}
