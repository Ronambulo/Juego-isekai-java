package com.isekai.entities;

import com.isekai.entities.decorator.*;

public class PlayerFactory {
    public Entity createPlayer(PlayerType playerType) {
        switch (playerType) {
            case WIZARD:
                return new WandDecorator(new TunicDecorator(new RangePlayer()));
            case PALADIN:
                return new SwordDecorator(new PaladinArmorDecorator(new MeleePlayer()));
            case BERSERK:
                return new AxesDecorator(new LeatherArmorDecorator(new MeleePlayer()));
            case ARCHER:
                return new BowDecorator(new LeatherArmorDecorator(new RangePlayer()));
            case KNIGHT:
                return new SwordDecorator(new KnightArmorDecorator(new MeleePlayer()));
            default:
            return new SwordDecorator(new KnightArmorDecorator(new MeleePlayer()));
        }
    }
}
