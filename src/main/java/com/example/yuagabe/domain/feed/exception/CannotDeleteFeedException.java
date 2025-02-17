package com.example.yuagabe.domain.feed.exception;

import com.example.yuagabe.global.error.CustomException;
import com.example.yuagabe.global.error.ErrorCode;

public class CannotDeleteFeedException extends CustomException {
    public static final CustomException EXCEPTION =
            new CannotDeleteFeedException();

    private CannotDeleteFeedException(){
        super(ErrorCode.CANNOT_DELETE_FEED);
    }
}
