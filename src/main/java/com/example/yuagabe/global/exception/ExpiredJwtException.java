package com.example.yuagabe.global.exception;


import com.example.yuagabe.global.error.CustomException;
import com.example.yuagabe.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }

}