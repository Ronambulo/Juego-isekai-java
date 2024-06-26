package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class SwordDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Sword";
    public static final Integer DEFAULT_LIVES = 0;
    public static final Integer DEFAULT_POWER = 6;

    public SwordDecorator(AbstractPlayerComponent playerComponent){
        super(playerComponent, SwordDecorator.DEFAULT_POWER, SwordDecorator.DEFAULT_LIVES, SwordDecorator.DEFAULT_NAME);
    }
}
