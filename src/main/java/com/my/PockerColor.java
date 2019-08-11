package com.my;

public enum PockerColor {
    CLUB("CLUB"), SPADE("SPADE"), HEART("HEART"),DIAMOND("DIAMOND");
    private String color;

    PockerColor(String color) {
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
