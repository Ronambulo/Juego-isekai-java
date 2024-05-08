package com.isekai.entities;

public abstract class Ogre extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 5;
    protected final Integer DEFAULT_LIVES = 14;
    public String weapon;

    public Ogre() {
        //TODO por ahora
        this.weapon = "Mazo";
        this.attackType = AttackType.RANGE;
    }

    public String getGenre() {
        return this.weapon;
    }

    //TODO
    
    public String getModification() {
        return this.weapon;
    }
}
