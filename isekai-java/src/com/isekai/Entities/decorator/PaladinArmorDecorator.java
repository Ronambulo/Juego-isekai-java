package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class PaladinArmorDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Paladin Armor";
    public static final Integer DEFAULT_LIVES = 40;
    public static final Integer DEFAULT_POWER = -2;

    public PaladinArmorDecorator(PlayerComponent playerComponent){
        super(playerComponent, PaladinArmorDecorator.DEFAULT_POWER, PaladinArmorDecorator.DEFAULT_LIVES, PaladinArmorDecorator.DEFAULT_NAME);
    }
}
