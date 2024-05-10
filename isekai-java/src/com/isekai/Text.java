package com.isekai;

public enum Text {
    INTRODUCTION(1), 
    ATTACK(2), 
    HEAL(3), 
    DEFENSE(4), 
    KILL(5), 
    WIN(6), 
    LOOSE(7);

    private Integer numberForText;

    Text(Integer numberForText) {
        this.numberForText = numberForText;
    }

    public Integer getNumber() {
        return this.numberForText;
    }
}