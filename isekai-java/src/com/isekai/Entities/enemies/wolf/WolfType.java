package com.isekai.entities.enemies.wolf;

public enum WolfType {
    ALFA("Alpha") ,BETA("Beta"),GAMMA("Gamma");

    private String wolfType;

    private WolfType(String wolfType) {
        this.wolfType = wolfType;
    }

    public String getColor() {
        return wolfType;
    }

    public static WolfType getRandomColor() {
        return WolfType.values()[(int) (Math.random() * WolfType.values().length)];
    }
}
