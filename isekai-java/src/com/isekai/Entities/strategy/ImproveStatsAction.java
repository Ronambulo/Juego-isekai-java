package com.isekai.entities.strategy;

import com.isekai.entities.*;
import com.isekai.entities.enemies.World;
import com.isekai.*;

public class ImproveStatsAction implements ActionStrategy{

    ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();

	@Override
	public void performAction(Integer world, Entity entity) {
        if(entity.getNumberOfCures() > 0){
            if(world == 1)
                entity.modifyHealth((int)Calculator.getRandomDoubleBetweenRange(9, 13));
            else
                entity.modifyHealth((int)Calculator.getRandomDoubleBetweenRange(9, 13) * World.LEVEL2.getComplexFactor());

            entity.setNumberOfCures(entity.getNumberOfCures() - 1);
            consoleTextManager.writeText(entity, Text.HEAL);
        }
        else{
            System.out.println("No tienes pociones de curación");
        }
	}

	@Override
	public void performAction(Entity attacker, Entity attacked) {
		
	}
}
