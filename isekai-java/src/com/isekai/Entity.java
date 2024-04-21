package com.isekai;

public interface Entity {
    public String getName();
    public Integer getPower();
    public Integer getLives();
    public AttackType getAttackType();
    public void setPower(Integer power);
    public void setLives(Integer lives);
}
