package com.isekai.entities;

public abstract class Wolf extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 4;
    protected final Integer DEFAULT_LIVES = 10;
    public String alfa;

    public Wolf() {
        this.attackType = AttackType.MELEE;
    }

    public String getGenre() {
        return this.alfa;
    }

    public void turn(){
        //TODO
    }  
}
