package com.isekai.entities;
import com.isekai.entities.state.*;

public abstract class Entity {
    protected Integer power;
    protected Integer lives = 0;
    private EntityState currentState;
    
    public Entity() {
        super();
        currentState = new NormalState(this);
    }

    public abstract String getName();
    public abstract Integer getPower();
    public abstract Integer getLives();
    public abstract AttackType getAttackType();
    public abstract void setLives(Integer lives);

    public EntityState getCurrentState() {
        return this.currentState;
    }
    public void setCurrentState(EntityState currentState) {
        this.currentState = currentState;
    }

    public void heal(Integer lives) {
        this.lives += lives;
    }
} 
