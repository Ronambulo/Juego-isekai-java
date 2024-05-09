package com.isekai.entities.strategy;

import com.isekai.entities.Entity;

public class Battle {
    public static final AttackStrategy ATTACK_STRATEGY_DEFAULT = new NeutralAttackStrategy();

    private AttackStrategy attackStrategy;

    public Battle() {
        this(Battle.ATTACK_STRATEGY_DEFAULT);
    }

    public Battle(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void setContextStrategy(AttackStrategy attackStrategy){
        this.attackStrategy= attackStrategy;
    }
    public AttackStrategy getContextStrategy(){
        return this.attackStrategy;
    }

    public void attack(Entity player, Entity enemy){
        this.attackStrategy.attack(player, enemy);
    }
}
