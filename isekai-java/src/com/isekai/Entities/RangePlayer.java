package com.isekai.entities;

public class RangePlayer extends PlayerComponent{
    protected Integer power;
    protected Integer lives;
    protected AttackType attackType;

    public RangePlayer() {
        this.power = 40;
        this.lives = 20;
        this.attackType = AttackType.RANGE;
    }

    public String getName() {
        return this.name;
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

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
