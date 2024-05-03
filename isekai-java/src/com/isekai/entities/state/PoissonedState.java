package com.isekai.entities.state;
import com.isekai.Calculator;
import com.isekai.entities.*;

public class PoissonedState implements EntityState{
    public Entity entity;

    public PoissonedState(Entity entity){
        this.entity = entity;
    }

    @Override
    public void show(Entity entityContext) {
        if(entityContext.getLives() > 0){
            System.out.println("Poissoned State");
        }
        else{
            this.entity.setCurrentState(new DeadState(entityContext));
        }
    }

    @Override
    public void attack(Entity attacker, Entity attacked) {
        show(attacked);
    }

    

    
}
