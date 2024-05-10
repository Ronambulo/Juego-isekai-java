package com.isekai.entities.factory;

public class SlimeWorld2 extends Slime{
    public SlimeWorld2() {
        super();
        this.power = DEFAULT_POWER * World.LEVEL2.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL2.getComplexFactor();
    }
}
