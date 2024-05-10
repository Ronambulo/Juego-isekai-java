package com.isekai.entities.factory;

import com.isekai.entities.AttackType;

public abstract class Ogre extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 10;
    protected final Integer DEFAULT_LIVES = 20;
    public String weapon;

    public Ogre() {
        //TODO por ahora
        this.weapon = "Mazo";
        this.attackType = AttackType.MELEE;
    }

    public String getWeapon() {
        return this.weapon;
    }

    //TODO
    
    public String getModification() {
        return getWeapon();
    }
}