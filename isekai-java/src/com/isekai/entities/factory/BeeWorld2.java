package com.isekai.entities.factory;

public class BeeWorld2 extends Bee{
    public BeeWorld2() {
        super();
        this.power = DEFAULT_POWER * World.LEVEL1.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL1.getComplexFactor();
    }

}
