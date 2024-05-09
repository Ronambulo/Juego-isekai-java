package com.isekai.entities;

public class MeleePlayer extends PlayerComponent{
    protected Integer power;
    protected Integer lives;
    protected AttackType attackType;

    public MeleePlayer() {
        this.power = 10;
        this.lives = 20;
        this.attackType = AttackType.MELEE;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
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
        return getName() + " AttackType: " + getAttackType();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
