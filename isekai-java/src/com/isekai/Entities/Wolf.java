package com.isekai.entities;

public abstract class Wolf extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 4;
    protected final Integer DEFAULT_LIVES = 10;
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
