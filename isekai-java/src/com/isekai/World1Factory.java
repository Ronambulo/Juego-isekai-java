package com.isekai;
import com.isekai.entities.*;
import com.isekai.entities.factory.*;

public class World1Factory implements WorldAbstractFactory{

    public Slime createSlime(){
        return new SlimeWorld1(); 
    }

    public Bee createBee(){
        return new BeeWorld1(); 
    }

    public Goat createGoat(){
        return new GoatWorld1(); 
    }

    public Ogre createOgre(){
        return new OgreWorld1(); 
    }

    public Wolf createWolf(){
        return new WolfWorld1(); 
    }

    @Override
    public Entity createRandomEnemy() {
        Entity enemy = null;
        Double random = Calculator.getRandomDoubleBetweenRange(0, 100);
        
        if(random < 40){
            enemy = createSlime();
        }
        else if(random < 60){
            enemy = createBee();
        }
        else if(random < 80){
            enemy = createGoat();
        }
        else if(random < 95){
            enemy = createWolf();
        }
        else{
            enemy = createOgre();
        }

        return enemy;
    }
}
