package com.isekai.entities.strategy;

import com.isekai.Calculator;
import com.isekai.ConsoleTextManager;
import com.isekai.Text;
import com.isekai.entities.*;

public class AttackActionStrategy implements ActionStrategy{
    private Calculator calculator = Calculator.getInstance();
    private ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();

    public void performAction(Integer world, Entity entity){
        System.err.println("No se puede realizar esta acción");
    }

    @Override
    public void performAction(Entity attacker, Entity attacked){
        attacked.setLives(calculator.calculateLives(attacker, attacked));
        consoleTextManager.writeText(attacker, attacked, Text.ATTACK);
    }
}
