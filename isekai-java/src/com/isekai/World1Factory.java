package com.isekai;

import com.isekai.entities.*;

public class World1Factory implements WorldAbstractFactory{

    public Slime createSlime(){
        return new SlimeWorld1(); //TODO: Implementar color aleatorio y contexto del Strategy
    }

    public Bee createBee(){
        return new BeeWorld1(); //TODO: Implementar color aleatorio y contexto del Strategy
    }

    public Goat createGoat(){
        return new GoatWorld1(); //TODO: Implementar color aleatorio y contexto del Strategy
    }

    public Ogre createOgre(){
        return new OgreWorld1(); //TODO: Implementar color aleatorio y contexto del Strategy
    }

    public Wolf createWolf(){
        return new WolfWorld1(); //TODO: Implementar color aleatorio y contexto del Strategy
    }

    @Override
    public Entity createRandomEnemy() {
        Entity enemy = null;
        Calculator calculator = Calculator.getInstance();
        Double random = calculator.getRandomDoubleBetweenRange(0, 100);
        
        if(random < 40){
            enemy = createSlime();
        }
        else if(random < 60){
            enemy = createBee();
        }
        else if(random < 80){
            enemy = createGoat();
        }
        else if(random < 90){
            enemy = createOgre();
        }
        else{
            enemy = createWolf();
        }

        return enemy;
    }
}
