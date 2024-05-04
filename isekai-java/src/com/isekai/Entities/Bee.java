package com.isekai.entities;

public abstract class Bee extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 2;
    protected final Integer DEFAULT_LIVES = 10;
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
