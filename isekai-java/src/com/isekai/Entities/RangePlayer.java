package com.isekai.entities;

public class RangePlayer extends PlayerComponent{
    protected Integer power;
    protected Integer lives;
    protected AttackType attackType;

    public RangePlayer() {
        this.power = 10;
        this.lives = 3;
        this.attackType = AttackType.RANGE;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public Integer getPower() {
        return this.power;
    }

    public AttackType getAttackType() {
        return this.attackType;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public Integer getLives() {
        return this.lives;
    }

    public String getDescription(){
        return getName() + " AttackType: " + getAttackType() +  ", lives=" + getLives() + ", power=" + getPower() + "]";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
