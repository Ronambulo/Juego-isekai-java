package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class BowDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Bow";
    public static final Integer DEFAULT_LIVES = 0;
    public static final Integer DEFAULT_POWER = 2;

    public BowDecorator(PlayerComponent playerComponent){
        super(playerComponent, BowDecorator.DEFAULT_POWER, BowDecorator.DEFAULT_LIVES, BowDecorator.DEFAULT_NAME);
    }
}
