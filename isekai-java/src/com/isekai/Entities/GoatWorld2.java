package com.isekai.entities;

public class GoatWorld2 extends Goat{
    public GoatWorld2() {
        super();
        this.power = DEFAULT_POWER * World.LEVEL1.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL1.getComplexFactor();
    }
}
