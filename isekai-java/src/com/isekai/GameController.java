package com.isekai;

import com.isekai.entities.*;

public class GameController {
    private static GameController instance;

    private WorldAbstractFactory world1Factory = new World1Factory();
    private WorldAbstractFactory world2Factory = new World2Factory();
    private PlayerFactory playerFactory = new PlayerFactory();


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
        ConsoleTextManager consoleTextManager = new ConsoleTextManager();

        consoleTextManager.writeText(Texto.INTRODUCTION);
         
        Entity slime1 = world1Factory.createSlime();
        System.out.println(slime1.toString());
        Entity slime2 = world2Factory.createSlime();
        System.out.println(slime2.toString());

        Entity player = playerFactory.createPlayer(PlayerType.BERSERK);
        System.out.println(player.toString());
        System.out.println("Power: " + player.getPower() + " Lives: " + player.getLives());

        consoleTextManager.writeText(slime1, slime2, Texto.ATTACK);
        consoleTextManager.writeText(slime2, Texto.KILL);
    }
}