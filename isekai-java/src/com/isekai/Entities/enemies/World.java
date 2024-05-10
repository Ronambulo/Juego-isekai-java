package com.isekai.entities.enemies;

public enum World {
    //Mundos que tenemos
    LEVEL1(1),LEVEL2(2);

    // Atributo que nos dice la complejidad del mundo
    private Integer complexFactor;

    World(Integer complexFactor) {
        this.complexFactor = complexFactor;
    }

    public Integer getComplexFactor() {
        return this.complexFactor;
    }
}