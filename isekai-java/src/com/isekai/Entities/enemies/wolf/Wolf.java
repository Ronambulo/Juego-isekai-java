package com.isekai.entities.enemies.wolf;

import com.isekai.entities.AttackType;
import com.isekai.entities.enemies.AbstractEnemy;

public abstract class Wolf extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 10;
    protected final Integer DEFAULT_LIVES = 17;
    public WolfType alfa;

    public Wolf() {
        this.alfa = WolfType.getRandomAlpha();
        this.attackType = AttackType.MELEE;
    }

    public String getAlpha() {
        return this.alfa.getWolfType();
    }

    @Override
    public String getModification() {
        return getAlpha();
    }
}
