package com.isekai.entities;

public interface Entity {
    public String getName();
    public Integer getPower();
    public Integer getLives();
    public AttackType getAttackType();
    public void setLives(Integer lives);
} 
