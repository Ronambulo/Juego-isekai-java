package com.isekai.entities.enemies;

public enum World {
    LEVEL1(1),LEVEL2(2);

    private Integer complexFactor;

    World(Integer complexFactor) {
        this.complexFactor = complexFactor;
    }

    public Integer getComplexFactor() {
        return this.complexFactor;
    }
}