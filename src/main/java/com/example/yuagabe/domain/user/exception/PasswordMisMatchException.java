package com.example.yuagabe.domain.user.exception;

import com.example.yuagabe.global.error.CustomException;
import com.example.yuagabe.global.error.ErrorCode;

public class PasswordMisMatchException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }

}