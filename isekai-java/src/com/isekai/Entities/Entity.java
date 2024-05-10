package com.isekai.entities;
import com.isekai.entities.state.*;
import com.isekai.entities.strategy.*;

public abstract class Entity {
    public static final Integer STARTING_NUMBER_OF_CURES = 1;

    protected Integer power;
    protected String name;
    protected Integer lives = 0;
    private EntityState currentState;
    protected AttackType attackType;  
    private ActionStrategy attackStrategy;
    protected Integer numberOfCures;
    
    public Entity() {
        this(Entity.STARTING_NUMBER_OF_CURES);
    }

    public Entity(Integer numberOfCures) {
        // El estado inicial de la entidad es NormalState
        this.currentState = new NormalState(this);
        // La estrategia por defecto es AttackActionStrategy (que simplemente ataque)
        this.attackStrategy = new AttackActionStrategy();
        this.numberOfCures = numberOfCures;
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }
    
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

    public Integer getNumberOfCures() {
        return this.numberOfCures;
    }

    public void setNumberOfCures(Integer numberOfCures) {
        this.numberOfCures = numberOfCures;
    }

    // Strategy Pattern
    public void setContextStrategy(ActionStrategy attackStrategy){
        this.attackStrategy= attackStrategy;
    }
    public ActionStrategy getContextStrategy(){
        return this.attackStrategy;
    }

} 
