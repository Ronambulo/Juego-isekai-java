package com.isekai.entities.enemies;

import com.isekai.entities.AttackType;
import com.isekai.entities.Entity;

public abstract class AbstractEnemy extends Entity{
    protected AttackType attackType;

    public String getName() {
        return super.getClass().getSuperclass().getSimpleName();
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
