package com.isekai.Entities;

import com.isekai.World;

public class SlimeWorld2 extends Slime{
    public SlimeWorld2() {
        this.power = DEFAULT_POWER * World.LEVEL2.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL2.getComplexFactor();
    }
}