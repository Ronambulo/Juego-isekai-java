package com.isekai.entities;

public interface PlayerComponent extends Entity{
    public String getName();
    public Integer getPower();
    public AttackType getAttackType();
    public void setLives(Integer lives);
    public Integer getLives();
    public String getDescription();
}