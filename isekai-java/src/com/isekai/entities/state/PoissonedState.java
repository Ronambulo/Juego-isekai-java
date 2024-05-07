package com.isekai.entities.state;
import com.isekai.entities.*;

public class PoissonedState implements EntityState{
    public Entity entity;

    public PoissonedState(Entity entity){
        this.entity = entity;
    }

    @Override
    public void show(Entity entityContext) {
        if(entityContext.getLives() > 0){
            System.out.println("El veneno ha hecho 1 de daño\n");
            //al estar envenenado perderá 1 de vida en cada turno
            entityContext.modifyHealth(-1);
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
