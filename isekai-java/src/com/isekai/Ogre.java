package com.isekai;

public abstract class Ogre extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 10;
    protected final Integer DEFAULT_LIVES = 1;
    public String weapon;

    public String getGenre() {
        return this.weapon;
    }

    public void turn(){
        //TODO
    }  
}
