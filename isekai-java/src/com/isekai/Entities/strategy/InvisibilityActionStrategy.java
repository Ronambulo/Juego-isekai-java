package com.isekai.entities.strategy;
import com.isekai.entities.*;

public class InvisibilityActionStrategy implements ActionStrategy{
    // private Calculator calculator = Calculator.getInstance();
    // private ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();

    public void performAction(Integer world, Entity entity){
        System.err.println("No se puede realizar esta acción");
    }

    @Override
    public void performAction(Entity attacker, Entity attacked){
        if(((PlayerComponent)attacker).getArcaneKnowledge() > 10){
            System.out.println("¡" + attacker.getName() + " se vuelve invisible y evita ser detectado!");
            ((PlayerComponent)attacker).setArcaneKnowledge(((PlayerComponent)attacker).getArcaneKnowledge() - 10);
        }
        else{
            System.out.println("¡" + attacker.getName() + " intenta volverse invisible, pero no tiene conocimiento arcano suficiente!");
        }
        
    }
}



