package com.example.yuagabe.domain.user.exception;

import com.example.yuagabe.global.error.CustomException;
import com.example.yuagabe.global.error.ErrorCode;

public class UserExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }

}