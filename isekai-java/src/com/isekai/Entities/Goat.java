package com.isekai.entities;

public abstract class Goat extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 3;
    protected final Integer DEFAULT_LIVES = 10;
    public Boolean scream;

    public Goat() {
        this.attackType = AttackType.MELEE;
    }

    public Boolean getScream() {
        return this.scream;
    }

    public void turn(){
        //TODO
    }  
}
