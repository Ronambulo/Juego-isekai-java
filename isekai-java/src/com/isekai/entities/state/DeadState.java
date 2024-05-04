package com.isekai.entities.state;
import com.isekai.entities.*;

public class DeadState implements EntityState{
    public Entity entity;
    
    public DeadState(Entity entity){
        this.entity = entity;
    }

    @Override
    public void show(Entity entityContext) {
        System.out.println("Dead State");
    }

    @Override
    public void attack(Entity attacker, Entity attacked) {
        show(attacked);
    }
}