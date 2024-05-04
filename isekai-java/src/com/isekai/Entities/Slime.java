package com.isekai.entities;

public abstract class Slime extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 1;
    protected final Integer DEFAULT_LIVES = 8;
    public SlimeColor color;

    public Slime() {
        this.attackType = AttackType.MELEE;
    }

    public SlimeColor getColor() {
        return color;
    }

    public void turn(){
        //TODO
    }
}
