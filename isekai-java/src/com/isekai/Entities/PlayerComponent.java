package com.isekai.entities;

public abstract class PlayerComponent extends Entity{
    protected Integer power;
    protected AttackType attackType;
    protected String name;

    public abstract String getName();
    public abstract void setName(String name);
    public abstract Integer getPower();
    public abstract AttackType getAttackType();
    public abstract String getDescription();
    public abstract void setLives(Integer lives);
    public abstract Integer getLives();
}