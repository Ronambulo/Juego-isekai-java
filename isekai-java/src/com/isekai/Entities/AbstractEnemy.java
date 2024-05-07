package com.isekai.entities;

public abstract class AbstractEnemy extends Entity{
    protected AttackType attackType;

    public String getName() {
        return super.getClass().getSimpleName();
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

    public abstract String getModification();

    @Override
    public String toString() {
        return super.getClass().getSuperclass().getSimpleName() + " " + getModification() + "\tPoder: " + getPower() + " Vida: " + getLives();
    }

}
