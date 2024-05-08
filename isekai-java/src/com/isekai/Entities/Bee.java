package com.isekai.entities;

import com.isekai.Calculator;

public abstract class Bee extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 17;
    protected final Integer DEFAULT_LIVES = 10;
    public BeeType genre;

    public Bee() {
        this.attackType = AttackType.RANGE;
        if(Calculator.getRandomDoubleBetweenRange(0, 2) <= 1){
            this.genre = BeeType.QUEEN;
        }
        else{
            this.genre = BeeType.DRONE;
        }
    }

    public BeeType getGenre() {
        return this.genre;
    }

    public String getModification() {
        return this.genre.getGenre();
    }

}
