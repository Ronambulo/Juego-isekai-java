package com.isekai.entities.decorator;

import com.isekai.entities.*;

public abstract class AbstractPlayerDecorator extends PlayerComponent{

    protected PlayerComponent playerComponent;

    protected Integer power;
    protected Integer lives;
    protected String name;

    public AbstractPlayerDecorator(PlayerComponent playerComponent, Integer power, Integer lives, String name){
        this.playerComponent = playerComponent;
        this.power = power;
        this.lives = lives;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPower() {
        return this.playerComponent.getPower() + this.power;
    }

    public AttackType getAttackType() {
        return this.playerComponent.getAttackType();
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public Integer getLives() {
        return this.playerComponent.getLives()+this.lives;
    }

    public String getDescription(){
        return this.playerComponent.getDescription() + " + " + this.getName();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
