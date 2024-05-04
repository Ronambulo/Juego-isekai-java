package com.isekai.entities;

public abstract class Ogre extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 5;
    protected final Integer DEFAULT_LIVES = 14;
    public String weapon;

    public Ogre() {
        this.attackType = AttackType.RANGE;
    }

    public String getGenre() {
        return this.weapon;
    }

    public void turn(){
        //TODO
    }  
}
