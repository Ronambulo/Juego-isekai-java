package com.isekai.entities.enemies.dragon;

import com.isekai.entities.enemies.World;

public class DragonWorld1 extends Dragon{

    public DragonWorld1(){
        super();
        this.power = DEFAULT_POWER * World.LEVEL1.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL1.getComplexFactor();
    }
}
