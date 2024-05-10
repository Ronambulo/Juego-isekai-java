package com.isekai.entities.strategy;

import com.isekai.*;
import com.isekai.entities.*;

public class AttackActionStrategy implements ActionStrategy{
    private ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();

    public void performAction(Integer world, Entity entity){
        System.err.println("No se puede realizar esta acción");
    }

    @Override
    public void performAction(Entity attacker, Entity attacked){
        attacked.modifyHealth(-attacker.getPower());
        consoleTextManager.writeText(attacker, attacked, Text.ATTACK);
    }
}
