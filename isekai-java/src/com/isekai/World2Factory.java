package com.isekai;

import com.isekai.entities.*;

public class World2Factory implements WorldAbstractFactory{
    
        public Slime createSlime(){
            return new SlimeWorld2(); //TODO: Implementar color aleatorio y contexto del Strategy
        }
        public Bee createBee(){
            return new BeeWorld2();
        }
        public Ogre createOgre(){
            return new OgreWorld2();
        }
        public Goat createGoat(){
            return new GoatWorld2();
        }
        public Wolf createWolf(){
            return new WolfWorld2();
        }

        @Override
        public Entity createRandomEnemy() {
            Entity enemy = null;
            Calculator calculator = Calculator.getInstance();
            Double random = calculator.getRandomDoubleBetweenRange(0, 100);
            
            if(random < 30){
                enemy = createSlime();
            }
            else if(random < 50){
                enemy = createBee();
            }
            else if(random < 60){
                enemy = createGoat();
            }
            else if(random < 80){
                enemy = createOgre();
            }
            else{
                enemy = createWolf();
            }
    
            return enemy;
        }
}
