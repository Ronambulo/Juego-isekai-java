package com.isekai.entities.decorator;

import com.isekai.entities.*;

public class LeatherArmorDecorator extends AbstractPlayerDecorator{
    public static final String DEFAULT_NAME = "Leather Armor";
    public static final Integer DEFAULT_LIVES = 20;
    public static final Integer DEFAULT_POWER = 0;

    public LeatherArmorDecorator(PlayerComponent playerComponent){
        super(playerComponent, LeatherArmorDecorator.DEFAULT_POWER, LeatherArmorDecorator.DEFAULT_LIVES, LeatherArmorDecorator.DEFAULT_NAME);
    }
}
