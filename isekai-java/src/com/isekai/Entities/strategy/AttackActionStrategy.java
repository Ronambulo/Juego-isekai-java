package com.isekai.entities.strategy;

import com.isekai.*;
import com.isekai.entities.*;

public class AttackActionStrategy implements ActionStrategy{
    private ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();

    public void performAction(Object object, Entity attacked){
        //En este metodo casteamos object a Entity para poder realizar el ataque
        //Realiza básicamente el ataque de un personaje a otro
        attacked.modifyHealth(-((Entity)object).getPower());
        consoleTextManager.writeText(((Entity)object), attacked, Text.ATTACK);
    }
}
