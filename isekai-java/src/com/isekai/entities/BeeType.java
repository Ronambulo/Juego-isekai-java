package com.isekai.entities;

public enum BeeType {
    QUEEN("Reina"), DRONE("Zángano");

    private String genre;

    private BeeType(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }
}
