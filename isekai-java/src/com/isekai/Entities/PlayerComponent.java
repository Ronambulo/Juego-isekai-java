package com.isekai.entities;

public abstract class PlayerComponent extends Entity{
    protected Integer power;
    protected AttackType attackType;

    public abstract String getName();
    public abstract Integer getPower();
    public abstract AttackType getAttackType();
    public abstract String getDescription();
    public abstract void setLives(Integer lives);
    public abstract Integer getLives();
}