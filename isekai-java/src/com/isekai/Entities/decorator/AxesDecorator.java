package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class AxesDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Axes";
    public static final Integer DEFAULT_LIVES = 0;
    public static final Integer DEFAULT_POWER = 10;

    public AxesDecorator(PlayerComponent playerComponent){
        super(playerComponent, AxesDecorator.DEFAULT_POWER, AxesDecorator.DEFAULT_LIVES, AxesDecorator.DEFAULT_NAME);
    }
}
