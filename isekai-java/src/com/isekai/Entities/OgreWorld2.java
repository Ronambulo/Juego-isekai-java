package com.isekai.entities;

public class OgreWorld2 extends Ogre{
    public OgreWorld2() {
        this.power = DEFAULT_POWER * World.LEVEL2.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL2.getComplexFactor();
    }
}
