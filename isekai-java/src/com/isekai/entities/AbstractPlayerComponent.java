package com.isekai.entities;

public abstract class AbstractPlayerComponent extends Entity{

    private Integer arcaneKnowledge;
    private Boolean isInvisible;

    public AbstractPlayerComponent() {
        // Al ser un jugador, comenzamos con 3 números de cura, no como el enemigo que empieza con 1
        super(3);
        this.arcaneKnowledge = 0;
        this.isInvisible = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void modifyPower(Integer power) {
        this.power += power;
    }

    public String getDescription(){
        return getName() + " AttackType: " + getAttackType() +  ", lives=" + getLives() + ", power=" + getPower() + "]";
    }

    public String toString() {
        return getDescription();
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

