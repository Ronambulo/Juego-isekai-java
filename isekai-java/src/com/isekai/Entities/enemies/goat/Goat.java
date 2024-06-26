package com.isekai.entities.enemies.goat;
import com.isekai.Calculator;
import com.isekai.entities.AttackType;
import com.isekai.entities.enemies.AbstractEnemy;

public abstract class Goat extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 6;
    protected final Integer DEFAULT_LIVES = 15;
    public Boolean scream;

    public Goat() {
        this.attackType = AttackType.MELEE;

        if(Calculator.getRandomDoubleBetweenRange(0, 2) <= 1){
            this.scream = true;
        }
        else{
            this.scream = false;
        }
    }

    public Boolean getScream() {
        return this.scream;
    }

    public String getModification(){
        if(this.scream){
                return "Chillona";
        }
        else{
            return "Normal";
        }
    }
}
