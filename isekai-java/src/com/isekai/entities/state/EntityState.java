package com.isekai.entities.state;
import com.isekai.entities.*;

public interface EntityState {
    public void show(Entity entityContext);
    public void attack(Entity attacker, Entity attacked);
}
