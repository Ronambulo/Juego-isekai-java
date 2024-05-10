package com.isekai.entities.strategy;
import com.isekai.entities.*;

public class InvisibilityActionStrategy implements ActionStrategy{
    @Override
    public void performAction(Object attacker, Entity attacked){

        // Comprobamos si tiene más de 10 de conocimiento arcano
        if(((AbstractPlayerComponent)attacker).getArcaneKnowledge() >= 10){
            // Si tiene más de 10 de conocimiento arcano, se vuelve invisible
            System.out.println("¡" + ((Entity)attacker).getName() + " se vuelve invisible y evita ser detectado!");
            // Consumimos Conocimiento Arcano
            ((AbstractPlayerComponent)attacker).setArcaneKnowledge(((AbstractPlayerComponent)attacker).getArcaneKnowledge() - 10);
        }
        else{
            System.out.println("¡" + ((Entity)attacker).getName() + " intenta volverse invisible, pero no tiene conocimiento arcano suficiente!");
        }
    }
}



