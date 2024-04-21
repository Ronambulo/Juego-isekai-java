package com.isekai;

import com.isekai.entities.*;

public class World2Factory extends WorldAbstractFactory{
        public Slime createSlime(){
            return new SlimeWorld2(); //TODO: Implementar color aleatorio y contexto del Strategy
        }
    
        @Override
        public AbstractEnemy createRandomEnemy() {
            // TODO implementar patron Template Method, Aleatoriedad con el metodo de la WorldAbstractFactory y Strategy
            AbstractEnemy randomEnemy = new SlimeWorld2();
            return randomEnemy;
        }
}
