package com.example.yuagabe.domain.feed.exception;

import com.example.yuagabe.global.error.CustomException;
import com.example.yuagabe.global.error.ErrorCode;

public class FeedNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }

}
