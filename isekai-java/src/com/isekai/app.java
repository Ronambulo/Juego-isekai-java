package com.isekai;

public class app {
    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        gameController.play();
    }
}