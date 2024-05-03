package com.isekai.entities;

public abstract class PlayerComponent extends Entity{
    protected Integer power;
    protected Integer lives;
    protected AttackType attackType;

    public abstract String getName();
    public abstract Integer getPower();
    public abstract AttackType getAttackType();
    public abstract void setLives(Integer lives);
    public abstract Integer getLives();
    public abstract String getDescription();
}