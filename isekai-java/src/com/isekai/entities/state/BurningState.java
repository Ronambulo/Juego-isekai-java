package com.isekai.entities.state;
import com.isekai.Calculator;
import com.isekai.entities.*;

public class BurningState implements EntityState{
    public Entity entity;

    public BurningState(Entity entity){
        this.entity = entity;
    }

    @Override
    public void show(Entity entityContext) {
        if(entityContext.getLives() > 0){
            System.out.println("El quemado ha hecho 1 de daño\n");
            //al estar quemado perderá 1 de vida en cada turno
            entityContext.modifyHealth(-1);
            
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 20){
                entityContext.setCurrentState(new NormalState(entityContext));
            }
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
