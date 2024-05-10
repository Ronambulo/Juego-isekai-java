package com.isekai.entities.state;
import com.isekai.ConsoleTextManager;
import com.isekai.entities.*;

public class PoissonedState implements EntityState{
    public Entity entity;

    public PoissonedState(Entity entity){
        this.entity = entity;
    }

    // Muestra el estado de la entidad
    @Override
    public void show(Entity entityContext) {
        System.out.print("Estado de " + entityContext.getName() + ": \t" + ConsoleTextManager.ANSI_GREEN +"Envenenado" + ConsoleTextManager.ANSI_RESET);
    }

    @Override
    public void attack(Entity attacker, Entity attacked) {

        // Si la entidad está viva
        if(attacked.getLives() > 0){
            //al estar envenenado perderá 5 de vida en cada turno
            System.out.println("El veneno ha hecho 5 de daño a " + attacked.getName() + "\n");
            attacked.modifyHealth(-5);
        }
        else{
            //Si no, está muerto, se le cambia el estado
            this.entity.setCurrentState(new DeadState(attacked));
        }
    }   
}
