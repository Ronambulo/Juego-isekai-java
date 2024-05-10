package com.isekai.entities.factory;

import com.isekai.entities.AttackType;

public abstract class Bee extends AbstractEnemy{
    protected static final Integer DEFAULT_POWER = 8;
    protected static final Integer DEFAULT_LIVES = 10;
    private BeeType genre;

    public Bee() {
        this.attackType = AttackType.RANGE;
        this.genre = BeeType.getRandomGenre();
    }

    public BeeType getGenre() {
        return this.genre;
    }

    public String getModification() {
        return this.genre.getGenre();
    }

}
