package com.isekai.entities.enemies.wolf;

public enum WolfType {
    ALFA("Alpha") ,BETA("Beta"),GAMMA("Gamma");

    private String wolfType;

    private WolfType(String wolfType) {
        this.wolfType = wolfType;
    }

    public String getWolfType() {
        return wolfType;
    }

    // Lo mismo, pero random WolfType
    public static WolfType getRandomAlpha() {
        return WolfType.values()[(int) (Math.random() * WolfType.values().length)];
    }
}
