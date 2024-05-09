package com.isekai.entities;

public class RangePlayer extends PlayerComponent{

    public RangePlayer() {
        super();
        this.power = 10;
        this.lives = 20;
        this.attackType = AttackType.RANGE;
    }

}
