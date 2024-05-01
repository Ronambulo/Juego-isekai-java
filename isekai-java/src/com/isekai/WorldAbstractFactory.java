package com.isekai;

import com.isekai.entities.*;

public abstract class WorldAbstractFactory {

    public static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()*(max-min))+min;
    }

    public abstract Slime createSlime();
    

    public AbstractEnemy createRandomEnemy(){
        AbstractEnemy randomEnemy;
        double aleatorio = getRandomDoubleBetweenRange(0, 100);
        
        return null; //TODO llamar a los create
    }
}   