package com.example.yuagabe.domain.feed.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Season {
    SPRING("봄"),

    SUMMER("여름"),

    AUTUMN("가을"),

    WINTER("겨울");

    private final String season;

    Season(String season) {
        this.season = season;
    }

    @JsonCreator
    public static Season from(String value) {
        return Arrays.stream(Season.values())
                .filter(season -> season.season.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 season 값입니다: " + value));
    }

    @JsonValue
    public String getSeason(){
        return season;
    }

}
