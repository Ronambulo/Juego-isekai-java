package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class WandDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Wand";
    public static final Integer DEFAULT_LIVES = 0;
    public static final Integer DEFAULT_POWER = 20;

    public WandDecorator(PlayerComponent playerComponent) {
        super(playerComponent, WandDecorator.DEFAULT_POWER, WandDecorator.DEFAULT_LIVES, WandDecorator.DEFAULT_NAME);
    }
}
