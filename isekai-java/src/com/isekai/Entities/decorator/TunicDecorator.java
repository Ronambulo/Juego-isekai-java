package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class TunicDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Tunic";
    public static final Integer DEFAULT_LIVES = 10;
    public static final Integer DEFAULT_POWER = 0;

    public TunicDecorator(PlayerComponent playerComponent){
        super(playerComponent, TunicDecorator.DEFAULT_POWER, TunicDecorator.DEFAULT_LIVES, TunicDecorator.DEFAULT_NAME);
    }
}
