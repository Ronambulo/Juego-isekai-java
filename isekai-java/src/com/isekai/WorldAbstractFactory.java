package com.isekai;

public abstract class WorldAbstractFactory {

    public static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()*(max-min))+min;
    }

    public AbstractEnemy createRandomEnemy(){
        AbstractEnemy randomEnemy;
        double aleatorio = getRandomDoubleBetweenRange(0, 100);
        
        return null; //TODO: Implementar patron Template Method
    }
}   