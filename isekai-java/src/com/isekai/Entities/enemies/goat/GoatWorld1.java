package com.isekai.entities.enemies.goat;

import com.isekai.entities.enemies.World;

public class GoatWorld1 extends Goat{
    public GoatWorld1() {
        super();
        this.power = DEFAULT_POWER * World.LEVEL1.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL1.getComplexFactor();
    }
}
