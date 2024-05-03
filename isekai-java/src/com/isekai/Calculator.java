package com.isekai;

public class Calculator {
    private static Calculator instance;

    private Calculator() {}

    public Calculator getInstance(){
        if(instance == null){
            instance = new Calculator();
        }
        return instance;
    }

    public static double getRandomDoubleBetweenRange(double min, double max){
        return(Math.random()* (max-min))+min;
    }
}
