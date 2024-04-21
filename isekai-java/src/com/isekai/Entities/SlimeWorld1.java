package com.isekai.Entities;

import com.isekai.World;

public class SlimeWorld1 extends Slime{
    public SlimeWorld1() {
        super();
        this.power = DEFAULT_POWER * World.LEVEL1.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL1.getComplexFactor();
    }
}