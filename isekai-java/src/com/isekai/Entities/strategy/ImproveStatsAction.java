package com.isekai.entities.strategy;
import com.isekai.entities.*;
import com.isekai.*;

public class ImproveStatsAction implements ActionStrategy{

    ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();

	@Override
	public void performAction(Object object, Entity entity) {

        // Comprobamos si tiene más de 100 de Conocimiento Arcano
        if(((AbstractPlayerComponent)entity).getArcaneKnowledge() >= 100){
            // Mejoramos las estadísticas del jugador (el poderS)
            ((AbstractPlayerComponent)entity).modifyPower((int)object);
            // Restamos 100 de Conocimiento Arcano
            ((AbstractPlayerComponent)entity).setArcaneKnowledge(((AbstractPlayerComponent)entity).getArcaneKnowledge() - 100);
        }
        else{
            System.out.println("No tienes suficiente conocimiento arcano como para mejorar tus estadísticas");
        }
	}
}
