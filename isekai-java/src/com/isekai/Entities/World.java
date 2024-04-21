package com.isekai.entities;

public enum World {
    LEVEL1(1),LEVEL2(2);

    World(Integer complexFactor) {
        this.complexFactor = complexFactor;
    }

    private Integer complexFactor;

    public Integer getComplexFactor() {
        return this.complexFactor;
    }
}