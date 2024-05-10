package com.isekai.entities.state;
import com.isekai.Calculator;
import com.isekai.entities.*;
import com.isekai.entities.decorator.*;
import com.isekai.entities.enemies.bee.Bee;
import com.isekai.entities.enemies.bee.BeeType;
import com.isekai.entities.enemies.slime.Slime;
import com.isekai.entities.enemies.slime.SlimeColor;

public class NormalState implements EntityState{
    private Entity entity;

    public NormalState(Entity entity){
        this.entity = entity;
    }

    @Override
    public void show(Entity entityContext) {
        if(entityContext.getLives() > 0){
            System.out.print("Estado de " + entityContext.getName() + ": \tNormal");
        }
        else{
            this.entity.setCurrentState(new DeadState(entityContext));
        }
    }

    public void attack(Entity attacker, Entity attacked){
        if(attacker instanceof AbstractPlayerComponent){
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
        //envenenará sólo si es una abeja reina
        if(attacker instanceof Bee && ((Bee)attacker).getGenre() == BeeType.QUEEN){
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 20){
                attacked.setCurrentState(new PoissonedState(attacked));
            }
        }

        //quemará sólo si es un slime rojo
        if(attacker instanceof Slime && ((Slime)attacker).getColor() == SlimeColor.RED){
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 10){
                attacked.setCurrentState(new BurningState(attacked));
            }
        }

        //si es un slime multicolor, tendrá un 50/50 de envenenar o quemar
        //y luego tendrá un 20% de probabilidad de envenenar y un 20% de quemar
        if(attacker instanceof Slime && ((Slime)attacker).getColor() == SlimeColor.RAINBOW){
            if(Calculator.getRandomDoubleBetweenRange(0, 2) <= 1){
                if(Calculator.getRandomDoubleBetweenRange(0, 100) < 20){
                    attacked.setCurrentState(new PoissonedState(attacked));
                }
            }
            else{
                if(Calculator.getRandomDoubleBetweenRange(0, 100) < 20){
                    attacked.setCurrentState(new BurningState(attacked));
                }
            }
        }
    }
}
