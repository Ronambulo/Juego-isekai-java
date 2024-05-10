package com.isekai.entities;

public abstract class AbstractPlayerComponent extends Entity{

    private Integer arcaneKnowledge;
    private Boolean isInvisible;

    public AbstractPlayerComponent() {
        super(3);
        this.arcaneKnowledge = 0;
        this.isInvisible = false;
    }

    public String getName() {
        return this.name;
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
        return getName() + " AttackType: " + getAttackType() +  ", lives=" + getLives() + ", power=" + getPower() + "]";
    }

    public String toString() {
        return getDescription();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArcaneKnowledge() {
        return arcaneKnowledge;
    }

    public void setArcaneKnowledge(Integer arcaneKnowledge) {
        this.arcaneKnowledge = arcaneKnowledge;
    }

    public Boolean getIsInvisible() {
        return isInvisible;
    }

    public void setIsInvisible(Boolean isInvisible) {
        this.isInvisible = isInvisible;
    }

}

