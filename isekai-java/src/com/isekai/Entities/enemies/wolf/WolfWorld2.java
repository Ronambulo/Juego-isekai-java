package com.isekai.entities.enemies.wolf;

import com.isekai.entities.enemies.World;

public class WolfWorld2 extends Wolf{
    public WolfWorld2() {
        super();
        this.power = DEFAULT_POWER * World.LEVEL1.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL1.getComplexFactor();
    }
}
