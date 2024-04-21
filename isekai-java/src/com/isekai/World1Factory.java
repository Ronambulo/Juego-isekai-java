package com.isekai;

public class World1Factory extends WorldAbstractFactory{

    public Slime createSlime(){
        return new SlimeWorld1(); //TODO: Implementar color aleatorio y contexto del Strategy
    }

    @Override
    public AbstractEnemy createRandomEnemy() {
        // TODO implementar patron Template Method, Aleatoriedad con el metodo de la WorldAbstractFactory y Strategy
        AbstractEnemy randomEnemy = new SlimeWorld1();
        return randomEnemy;
    }
}
