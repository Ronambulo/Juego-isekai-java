package com.isekai.entities.strategy;

import com.isekai.entities.*;
import com.isekai.entities.enemies.World;
import com.isekai.*;

public class HealActionStrategy implements ActionStrategy{

    ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();

	@Override
	public void performAction(Object object, Entity entity) {

        // Comprobamos si tiene más de 10 Conocimiento Arcano
        if(((AbstractPlayerComponent)entity).getArcaneKnowledge() >=  10){
            //Si estamos en el mundo  1, la curación puede ser de 9 a 13
            if(((int)object) == 1)
                entity.modifyHealth((int)Calculator.getRandomDoubleBetweenRange(9, 13));
            else
                //Si estamos en el mundo 2, la curación puede ser de 9 a 13 multiplicado por el factor de complejidad del mundo
                entity.modifyHealth((int)Calculator.getRandomDoubleBetweenRange(9, 13) * World.LEVEL2.getComplexFactor());

            consoleTextManager.writeText(entity, Text.HEAL);
            // Restamos 10 de conocimiento arcano, ya consumidos
            ((AbstractPlayerComponent)entity).setArcaneKnowledge(((AbstractPlayerComponent)entity).getArcaneKnowledge() - 10);
        }
        else{
            System.out.println("Intentaste curarte, pero no tienes suficiente conocimiento arcano como para hacer una poción");
        }
	}
}
