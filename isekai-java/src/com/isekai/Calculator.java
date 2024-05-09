package com.isekai;

import com.isekai.entities.*;

public class Calculator {
    private static Calculator instance;

    private Calculator() {}

    public static Calculator getInstance(){
        if(instance == null){
            instance = new Calculator();
        }
        return instance;
    }

    public static double getRandomDoubleBetweenRange(double min, double max){
        return(Math.random()* (max-min))+min;
    }

    public Integer calculateLives(Entity attacker, Entity attacked){
        return (attacked.getLives() - attacker.getPower());
    }

    public void calculateHealh(Entity entity, Integer healValue){
        entity.modifyHealth(healValue);
    }

    
}
