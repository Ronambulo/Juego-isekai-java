package com.isekai.entities.strategy;
import com.isekai.entities.*;

public interface ActionStrategy {
    public void performAction(Entity attacker, Entity attacked);
    public void performAction(Integer world, Entity entity);
} 
