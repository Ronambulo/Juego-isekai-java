package com.isekai.entities.state;
import com.isekai.Calculator;
import com.isekai.entities.*;
import com.isekai.entities.decorator.*;
import com.isekai.entities.enemies.bee.*;
import com.isekai.entities.enemies.slime.*;
import com.isekai.entities.enemies.dragon.Dragon;

public class NormalState implements EntityState{
    private Entity entity;

    public NormalState(Entity entity){
        this.entity = entity;
    }

    // Nos enseña el estado de la entidad
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
        // Dependiendo de si el atacante es un jugador
        if(attacker instanceof AbstractPlayerComponent){

            // Si el atacante es un jugador, entonces se le aplicarán los efectos de los items
            if(attacker instanceof WandDecorator){
                // Si el jugador tiene una varita, entonces tendrá un 10% de probabilidad de quemar al enemigo
                if(Calculator.getRandomDoubleBetweenRange(0, 100) < 10){
                    attacked.setCurrentState(new BurningState(attacked));
                }
            }
            // Si el jugador tiene un arco, entonces tendrá un 5% de probabilidad de envenenar al enemigo
            if(attacker instanceof BowDecorator){
                if(Calculator.getRandomDoubleBetweenRange(0, 100) < 5){
                    attacked.setCurrentState(new PoissonedState(attacked));
                }
            }
        }

        //------SI ES UN ENEMIGO------

        // Envenenará sólo si es una abeja reina
        if(attacker instanceof Bee && ((Bee)attacker).getGenre() == BeeType.QUEEN){
            // 20% de probabilidad de envenenar
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 20){
                attacked.setCurrentState(new PoissonedState(attacked));
            }
        }

        // Quemará sólo si es un slime rojo
        if(attacker instanceof Slime && ((Slime)attacker).getColor() == SlimeColor.RED){
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 10){
                attacked.setCurrentState(new BurningState(attacked));
            }
        }

        // Si es un dragón te quemará
        if(attacker instanceof Dragon){
            attacked.setCurrentState(new BurningState(attacked));
        }

        // Si es un slime multicolor, tendrá un 50/50 de envenenar o quemar
        // y luego tendrá un 20% de probabilidad de envenenar y un 20% de quemar
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
