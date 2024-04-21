package com.isekai;

public abstract class AbstractEnemy implements Entity{
    protected Integer power;
    protected Integer lives;
    protected AttackType attackType;

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

    @Override
    public String toString() {
        return getName() + " [attackType=" + getAttackType() + ", lives=" + getLives() + ", power=" + getPower() + "]";
    }

}
