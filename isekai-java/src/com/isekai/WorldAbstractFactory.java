package com.isekai;

import com.isekai.entities.*;
import com.isekai.entities.enemies.bee.*;
import com.isekai.entities.enemies.goat.*;
import com.isekai.entities.enemies.ogre.*;
import com.isekai.entities.enemies.slime.*;
import com.isekai.entities.enemies.wolf.*;
import com.isekai.entities.enemies.dragon.*;


public interface WorldAbstractFactory {
    Calculator calculator = Calculator.getInstance();

    public Slime createSlime();
    public Bee createBee();        
    public Ogre createOgre();
    public Goat createGoat();
    public Wolf createWolf();
    public Dragon createDragon();

    public Entity createRandomEnemy();
}