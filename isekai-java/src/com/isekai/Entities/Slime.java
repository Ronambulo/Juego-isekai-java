package com.isekai.entities;

public abstract class Slime extends AbstractEnemy{
    protected final Integer DEFAULT_POWER = 1;
    protected final Integer DEFAULT_LIVES = 8;
    public SlimeColor color;
    public String colorString;

    public Slime() {
        //TODO por ahora verde
        this.color = SlimeColor.GREEN;

        this.attackType = AttackType.MELEE;
    }

    public SlimeColor getColor() {
        return color;
    }

    //TODO
    @Override
    public String getModification() {
        return this.color.getColor();
    }
}
