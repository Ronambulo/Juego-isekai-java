package com.isekai.entities.factory;

public class BeeWorld1 extends Bee{
    public BeeWorld1() {
        super();
        this.power = DEFAULT_POWER * World.LEVEL1.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL1.getComplexFactor();
    }
}
