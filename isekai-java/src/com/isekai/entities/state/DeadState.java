package com.isekai.entities.state;
import com.isekai.entities.*;

public class DeadState implements EntityState{
    public Entity entity;
    
    public DeadState(Entity entity){
        this.entity = entity;
    }

    // La entidad está muerta, no puede hacer nada
    @Override
    public void show(Entity entityContext) {
        System.out.print("Estado de " + entityContext.getName() + ": \tMUERTO");
    }

    @Override
    public void attack(Entity attacker, Entity attacked) {
        show(attacked);
    }
    
}
