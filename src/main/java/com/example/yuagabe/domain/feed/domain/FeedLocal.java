package com.example.yuagabe.domain.feed.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FeedLocal {
    STYLE("스타일"),
    MAKEUP("메이크업");


    private final String feedLocal;

    FeedLocal(String feedLocal) {
        this.feedLocal = feedLocal;
    }

    @JsonCreator
    public static FeedLocal from(String value) {
        return Arrays.stream(FeedLocal.values())
                .filter(feedLocal -> feedLocal.feedLocal.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 feedLocal 값입니다: " + value));
    }

    @JsonValue
    public String getFeedLocal(){
        return feedLocal;
    }
}
