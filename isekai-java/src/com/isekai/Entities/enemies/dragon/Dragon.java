package com.isekai.entities.enemies.dragon;
import com.isekai.entities.enemies.AbstractEnemy;

public class Dragon extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 10;
    protected final Integer DEFAULT_LIVES = 200;

    @Override
    public String getModification() {
       return "ROJO";
    }
}
