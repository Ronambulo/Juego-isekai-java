package com.isekai.Entities;

public abstract class Slime extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 10;
    protected final Integer DEFAULT_LIVES = 1;
    public SlimeColor color;

    public SlimeColor getColor() {
        return color;
    }

    public void turn(){
        //TODO
    }
}
