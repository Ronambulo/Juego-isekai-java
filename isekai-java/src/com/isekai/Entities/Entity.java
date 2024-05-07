package com.isekai.entities;
import com.isekai.entities.state.*;

public abstract class Entity {
    protected Integer power;
    protected String name;
    protected Integer lives = 0;
    private EntityState currentState;
    
    public Entity() {
        super();
        currentState = new NormalState(this);
    }

    public String getName(){
        return this.getClass().getSimpleName();
    };
    
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

    public void modifyHealth(Integer lives) {
        this.lives += lives;
    }

} 
