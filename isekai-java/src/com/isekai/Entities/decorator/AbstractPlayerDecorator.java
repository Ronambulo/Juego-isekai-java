package com.isekai.entities.decorator;

import com.isekai.entities.*;

public abstract class AbstractPlayerDecorator extends PlayerComponent{

    protected PlayerComponent playerComponent;

    public AbstractPlayerDecorator(PlayerComponent playerComponent, Integer power, Integer lives, String name){
        this.playerComponent = playerComponent;
        this.power = power;
        this.lives = lives;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.playerComponent.getName();
    }

    @Override
    public void setName(String name){
        this.playerComponent.setName(name);
    }

    @Override
    public Integer getPower() {
        return this.playerComponent.getPower() + this.power;
    }

    @Override
    public AttackType getAttackType() {
        return this.playerComponent.getAttackType();
    }

    @Override
    public void setLives(Integer lives) {
        this.playerComponent.setLives(lives);
    }

    @Override
    public Integer getLives() {
        return this.playerComponent.getLives()+this.lives;
    }

    @Override
    public Integer getNumberOfCures() {
        return this.playerComponent.getNumberOfCures();
    }

    @Override
    public void setNumberOfCures(Integer numberOfCures) {
        this.playerComponent.setNumberOfCures(numberOfCures);
    }

    @Override
    public Integer getArcaneKnowledge() {
        return this.playerComponent.getArcaneKnowledge();
    }

    @Override
    public void setArcaneKnowledge(Integer arcaneKnowledge) {
        this.playerComponent.setArcaneKnowledge(arcaneKnowledge);
    }

    @Override
    public Boolean getIsInvisible() {
        return this.playerComponent.getIsInvisible();
    }

    @Override
    public void setIsInvisible(Boolean isInvisible) {
        this.playerComponent.setIsInvisible(isInvisible);
    }

    @Override
    public String getDescription(){
        return this.playerComponent.getDescription() + " + " + this.getName();
    }

    @Override
    public void modifyHealth(Integer lives) {
        this.lives += lives;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
