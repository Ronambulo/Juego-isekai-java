package com.isekai.Entities;

public abstract class Bee extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 10;
    protected final Integer DEFAULT_LIVES = 1;
    public String genre;

    public Bee() {
        this.attackType = AttackType.RANGE;
    }

    public String getGenre() {
        return this.genre;
    }

    public void turn(){
        //TODO
    }  
}
