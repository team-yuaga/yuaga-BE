package com.example.yuagabe.domain.like.exception;

import com.example.yuagabe.global.error.CustomException;
import com.example.yuagabe.global.error.ErrorCode;

public class AlreadyExistsLikeException extends CustomException {
    public static final CustomException EXCEPTION =
            new AlreadyExistsLikeException();

    public AlreadyExistsLikeException() {
        super(ErrorCode.LIKE_EXIST);
    }
}
