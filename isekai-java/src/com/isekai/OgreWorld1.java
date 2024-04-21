package com.isekai;

public class OgreWorld1 extends Ogre{
    public OgreWorld1() {
        this.power = DEFAULT_POWER * World.LEVEL2.getComplexFactor();
        this.lives = DEFAULT_LIVES * World.LEVEL2.getComplexFactor();
    }
}
