package com.isekai;

import com.isekai.entities.*;
import com.isekai.entities.enemies.bee.*;
import com.isekai.entities.enemies.goat.*;
import com.isekai.entities.enemies.ogre.*;
import com.isekai.entities.enemies.slime.*;
import com.isekai.entities.enemies.wolf.*;

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

    public Integer calculateArcaneKnowledge(AbstractPlayerComponent player, Entity enemy){
        if(enemy instanceof Slime){
            return (player.getArcaneKnowledge() + 2);
        }
        else if(enemy instanceof Bee){
            return (player.getArcaneKnowledge() + 3);
        }
        else if(enemy instanceof Goat){
            return (player.getArcaneKnowledge() + 5);
        }
        else if(enemy instanceof Wolf){
            return (player.getArcaneKnowledge() + 8);
        }
        else if(enemy instanceof Ogre){
            return (player.getArcaneKnowledge() + 10);
        }
        return 0;
    }
}
