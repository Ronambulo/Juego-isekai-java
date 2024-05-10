package com.isekai;

import com.isekai.entities.*;
import com.isekai.entities.enemies.bee.*;
import com.isekai.entities.enemies.goat.*;
import com.isekai.entities.enemies.ogre.*;
import com.isekai.entities.enemies.slime.*;
import com.isekai.entities.enemies.wolf.*;
import com.isekai.entities.enemies.dragon.*;

public class World2Factory implements WorldAbstractFactory{
    
        public Slime createSlime(){
            return new SlimeWorld2();
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

        public Dragon createDragon(){
            return new DragonWorld2();
        }

        @Override
        public Entity createRandomEnemy() {
            Entity enemy = null;
            Double random = Calculator.getRandomDoubleBetweenRange(0, 100);

            //calculamos un numero aleatorio y dependiendo de este, creamos un enemigo segun las probabilidades

            
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
