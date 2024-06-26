package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class KnightArmorDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Knight Armor";
    public static final Integer DEFAULT_LIVES = 30;
    public static final Integer DEFAULT_POWER = 0;

    public KnightArmorDecorator(AbstractPlayerComponent playerComponent){
        super(playerComponent, KnightArmorDecorator.DEFAULT_POWER, KnightArmorDecorator.DEFAULT_LIVES, KnightArmorDecorator.DEFAULT_NAME);
    }
}
