package com.isekai.entities.strategy;
import com.isekai.entities.Entity;

public abstract class AttackStrategy {

    public abstract void strategyAttack(Entity player, Entity enemy);

    public void attack(Entity attacker, Entity attacked){

    }
}
