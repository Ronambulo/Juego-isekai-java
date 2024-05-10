package com.isekai.entities.enemies.slime;

import com.isekai.entities.AttackType;
import com.isekai.entities.enemies.AbstractEnemy;

public abstract class Slime extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 5;
    protected final Integer DEFAULT_LIVES = 10;
    public SlimeColor color;

    public Slime() {
        this.color = SlimeColor.getRandomColor();
        this.attackType = AttackType.MELEE;
    }

    public SlimeColor getColor() {
        return color;
    }

    @Override
    public String getModification() {
        return this.color.getColor();
    }
}
