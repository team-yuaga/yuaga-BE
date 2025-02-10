package com.example.yuagabe.domain.user.presentation;

import com.example.yuagabe.domain.user.presentation.dto.request.SignUpRequest;
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

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignUpRequest request){
        signUpService.execute(request);
    }

}
