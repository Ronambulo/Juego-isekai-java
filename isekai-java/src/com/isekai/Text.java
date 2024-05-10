package com.isekai;

public enum Text {
    INTRODUCTION(1), 
    ATTACK(2), 
    HEAL(3), 
    DEFENSE(4), 
    KILL(5), 
    WIN(6), 
    LOOSE(7);

    Text(Integer n) {
        this.n = n;
    }

    private Integer n;

    public Integer getNumber() {
        return this.n;
    }
}