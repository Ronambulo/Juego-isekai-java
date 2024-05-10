package com.isekai.entities.enemies.bee;

public enum BeeType {
    QUEEN("Reina"), DRONE("Zángano");

    private String genre;

    private BeeType(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public static BeeType getRandomGenre() {
        return BeeType.values()[(int) (Math.random() * BeeType.values().length)];
    }
}
