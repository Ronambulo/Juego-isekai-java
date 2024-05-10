package com.isekai.entities.factory;

import com.isekai.entities.AttackType;

public abstract class Wolf extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 10;
    protected final Integer DEFAULT_LIVES = 17;
    public String alfa;

    public Wolf() {
        //TODO por ahora
        this.alfa = "ALFA";
        this.attackType = AttackType.MELEE;
    }

    public String getGenre() {
        return this.alfa;
    }

    //TODO
    @Override
    public String getModification() {
        return this.alfa;
    }
}
