package com.isekai.Entities;

public abstract class Wolf extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 10;
    protected final Integer DEFAULT_LIVES = 1;
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
