package com.isekai.entities.state;
import com.isekai.Calculator;
import com.isekai.entities.*;
import com.isekai.entities.decorator.*;

public class NormalState implements EntityState{
    private Entity entity;

    public NormalState(Entity entity){
        this.entity = entity;
    }

    @Override
    public void show(Entity entityContext) {
        if(entityContext.getLives() > 0){
            System.out.println("Normal State");
        }
        else{
            this.entity.setCurrentState(new DeadState(entityContext));
        }
    }

    public void attack(Entity attacker, Entity attacked){
        if(attacker instanceof PlayerComponent){
            if(attacker instanceof WandDecorator){
                if(Calculator.getRandomDoubleBetweenRange(0, 100) < 10){
                    attacked.setCurrentState(new BurningState(attacked));
                }
            }
            if(attacker instanceof BowDecorator){
                if(Calculator.getRandomDoubleBetweenRange(0, 100) < 5){
                    attacked.setCurrentState(new PoissonedState(attacked));
                }
            }
        }
        if(attacker instanceof Bee){
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 10){
                attacked.setCurrentState(new PoissonedState(attacked));
            }
        }
        if(attacker instanceof Slime){
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 10){
                attacked.setCurrentState(new BurningState(attacked));
            }
        }
        show(attacked);
    }
}
