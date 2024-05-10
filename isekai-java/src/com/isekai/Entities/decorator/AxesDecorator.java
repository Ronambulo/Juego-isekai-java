package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class AxesDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Axes";
    public static final Integer DEFAULT_LIVES = 0;
    public static final Integer DEFAULT_POWER = 11;

    public AxesDecorator(AbstractPlayerComponent playerComponent){
        super(playerComponent, AxesDecorator.DEFAULT_POWER, AxesDecorator.DEFAULT_LIVES, AxesDecorator.DEFAULT_NAME);
    }
}