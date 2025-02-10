package com.example.yuagabe.domain.user;

public enum UserPersonalColor {
    SPRING("봄웜"),
    SUMMER("여름쿨"),
    AUTUMN("가을웜"),
    WINTER("겨울쿨");


    private final String userPersonalColor;

    UserPersonalColor(String userPersonalColor) {
        this.userPersonalColor = userPersonalColor;
    }

    public String getUserPersonalColor() {
        return userPersonalColor;
    }


}
