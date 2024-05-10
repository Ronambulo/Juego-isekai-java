package com.isekai;

import com.isekai.entities.*;
import com.isekai.entities.factory.*;

public interface WorldAbstractFactory {
    Calculator calculator = Calculator.getInstance();

    public Slime createSlime();
    public Bee createBee();        
    public Ogre createOgre();
    public Goat createGoat();
    public Wolf createWolf();

    public Entity createRandomEnemy();
}