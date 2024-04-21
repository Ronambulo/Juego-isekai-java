package com.isekai;

public class GameController {
    private static GameController instance;

    private World1Factory world1Factory = new World1Factory(); //! error con WorldAbstractFactory
    private World2Factory world2Factory = new World2Factory(); //! error con WorldAbstractFactory

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
        AbstractEnemy slime1 = world1Factory.createSlime();
        System.out.println(slime1.toString());
        AbstractEnemy slime2 = world2Factory.createSlime();
        System.out.println(slime2.toString());
    }
}