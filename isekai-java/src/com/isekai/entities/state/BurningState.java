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
        System.out.print("Estado de " + entityContext.getName() + ": \tQuemado");
    }

    @Override
    public void attack(Entity attacker, Entity attacked) {
        if(attacked.getLives() > 0){
            System.out.println("El quemado ha hecho 5 de daño\n");
            //al estar quemado perderá 5 de vida en cada turno
            attacked.modifyHealth(-5);
            
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 20){
                attacked.setCurrentState(new NormalState(attacked));
            }
        }
        else{
            this.entity.setCurrentState(new DeadState(attacked));
        }
    }
}
