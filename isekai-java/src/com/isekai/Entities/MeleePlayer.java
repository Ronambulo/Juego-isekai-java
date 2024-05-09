package com.isekai.entities;

public class MeleePlayer extends PlayerComponent{

    public MeleePlayer() {
        super();
        this.power = 10;
        this.lives = 20;
        this.attackType = AttackType.MELEE;
    }
}
