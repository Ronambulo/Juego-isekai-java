package com.isekai;

public class App {
    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        gameController.play();
    }
}
