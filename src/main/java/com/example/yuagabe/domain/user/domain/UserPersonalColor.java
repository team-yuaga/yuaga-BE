package com.example.yuagabe.domain.user.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum UserPersonalColor {
    SPRING("봄웜"),
    SUMMER("여름쿨"),
    AUTUMN("가을웜"),
    WINTER("겨울쿨");


    private final String userPersonalColor;

    UserPersonalColor(String userPersonalColor) {
        this.userPersonalColor = userPersonalColor;
    }

    @JsonCreator
    public static UserPersonalColor from(String value) {
        return Arrays.stream(UserPersonalColor.values())
                .filter(color -> color.userPersonalColor.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 userPersonalColor 값입니다: " + value));
    }

    @JsonValue
    public String getUserPersonalColor() {
        return userPersonalColor;
    }


}
