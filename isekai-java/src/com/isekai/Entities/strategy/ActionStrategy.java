package com.isekai.entities.strategy;
import com.isekai.entities.*;

public interface ActionStrategy {
    // Pasamos un objeto, para poder castearlo dependiendo de la acción que se realice
    public void performAction(Object object, Entity attacked);
} 
