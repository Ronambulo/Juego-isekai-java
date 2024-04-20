package com.isekai;

public class GameController {
    private static GameController instance;

    private GameController() {
        super();
    }

    public static GameController getInstance() {
        if(instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void play() {
        System.out.println("Playing game...");
    }
}