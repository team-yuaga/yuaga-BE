package com.example.yuagabe.domain.user.presentation;

import com.example.yuagabe.domain.user.presentation.dto.request.NicknameChangeRequest;
import com.example.yuagabe.domain.user.presentation.dto.request.SignInRequest;
import com.example.yuagabe.domain.user.presentation.dto.request.SignUpRequest;
import com.example.yuagabe.domain.user.presentation.dto.request.UserInformationRequest;
import com.example.yuagabe.domain.user.presentation.dto.response.TokenResponse;
import com.example.yuagabe.domain.user.presentation.dto.response.UserInformationResponse;
import com.example.yuagabe.domain.user.service.*;
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
    private final UserInformationService userInformationService;
    private final GetUserInformationService getUserInformationService;

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

    @PatchMapping("/information")
    @ResponseStatus(HttpStatus.OK)
    public void information(@RequestBody @Valid UserInformationRequest request){
        userInformationService.execute(request);
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public UserInformationResponse user(){
        return getUserInformationService.execute();
    }
}
