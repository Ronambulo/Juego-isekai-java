package com.isekai.entities;

import com.isekai.Calculator;

public abstract class Bee extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 8;
    protected final Integer DEFAULT_LIVES = 10;
    public BeeType genre;

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
