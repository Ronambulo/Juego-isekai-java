package com.isekai.entities.state;
import com.isekai.Calculator;
import com.isekai.ConsoleTextManager;
import com.isekai.entities.*;

public class BurningState implements EntityState{
    public Entity entity;

    public BurningState(Entity entity){
        this.entity = entity;
    }

    // Nos muestra el estado de la entidad
    @Override
    public void show(Entity entityContext) {
        System.out.print("Estado de " + entityContext.getName() + ": \t" + ConsoleTextManager.ANSI_RED + "Quemado" + ConsoleTextManager.ANSI_RESET);
    }

    // Dentro del ataque, como la entidad está quemada, perderá 5 de vida en cada turno
    @Override
    public void attack(Entity attacker, Entity attacked) {
        //si la entidad atacada tiene más de 0 vidas
        if(attacked.getLives() > 0){
            System.out.println("El quemado ha hecho 5 de daño a " + attacked.getName() + "\n");
            // Al estar quemado perderá 5 de vida en cada turno
            attacked.modifyHealth(-5);

            //Tiene un 20% de posibilidad de dejar de estar quemado
            if(Calculator.getRandomDoubleBetweenRange(0, 100) < 20){
                attacked.setCurrentState(new NormalState(attacked));
            }
        }
        else{
            // Si la entidad atacada tiene 0 vidas, cambiará su estado a muerto
            this.entity.setCurrentState(new DeadState(attacked));
        }
    }
}
