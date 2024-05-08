package com.isekai.entities;

public enum SlimeColor {
    RED("Rojo") ,BLUE("Azul"),RAINBOW("Multicolor");

    private String color;

    private SlimeColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
