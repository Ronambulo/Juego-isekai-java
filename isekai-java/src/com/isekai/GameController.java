package com.isekai;
import java.util.ArrayList;
import java.util.Scanner;
import com.isekai.entities.*;
import com.isekai.entities.state.DeadState;

public class GameController {
    private static GameController instance;

    private WorldAbstractFactory world1Factory = new World1Factory();
    private WorldAbstractFactory world2Factory = new World2Factory();
    private PlayerFactory playerFactory = new PlayerFactory();
    private ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();
    private Entity player;
    private Calculator calculator = Calculator.getInstance();

    private ArrayList<Entity> world1Enemies;
    private ArrayList<Entity> world2Enemies;

    private Scanner scanner = new Scanner(System.in);
    private Boolean gameOver = false;

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
        consoleTextManager.writeText(Texto.INTRODUCTION);
        System.out.println("\n\n");
        player = SelectPlayer();
        spawnEnemies();

        System.out.println();

        //Mientras el jugador no esté muerto y el juego no haya terminado
        while(!(player.getCurrentState() instanceof DeadState) && !gameOver) {
            world1Enemies.forEach(enemy -> {
                while(enemy.getLives() > 0 && player.getLives() > 0)
                    turn(player, enemy);

                if(player.getLives() <= 0) {
                    gameOver = true;
                }
            });
            gameOver = true;
        }

        //! ESTO NO FUNCIONA POR QUE EL gameOVER ES TRUE SIEMPRE
        if(gameOver) {
            consoleTextManager.writeText(Texto.LOOSE);
        } else {
            consoleTextManager.writeText(Texto.WIN);
        }
        
    }

    private Entity SelectPlayer(){
        PlayerType playerType;
        
        System.out.println("Elije tu clase: ");
        System.out.println("1. Paladin");
        System.out.println("2. Mago");
        System.out.println("3. Berserk");
        System.out.println("4. Caballero");
        System.out.println("5. Arquero");

        switch (scanner.nextInt()) {
            case 1:
                playerType = PlayerType.PALADIN;
                break;
            case 2:
                playerType = PlayerType.WIZARD;
                break;
            case 3:
                playerType = PlayerType.BERSERK;
                break;
            case 4:
                playerType = PlayerType.KNIGHT;
                break;
            case 5:
                playerType = PlayerType.ARCHER;
                break;
            default:
                playerType = PlayerType.KNIGHT;
                break;
        }
        

        return playerFactory.createPlayer(playerType);
    }

    private Entity spawnRandomEnemy(WorldAbstractFactory factory) {
        return factory.createOgre();
    }

    private void spawnEnemies() {
        this.world1Enemies = new ArrayList<Entity>();
        this.world2Enemies = new ArrayList<Entity>();

        for(int i = 0; i < 10; i++) {
            this.world1Enemies.add(spawnRandomEnemy(this.world1Factory));
            this.world2Enemies.add(spawnRandomEnemy(this.world2Factory));
        }
    }

    private void turn(Entity player, Entity enemy) {
        // Llamar a los estados y al toString de ambos para tipico nombre, vida, etc de pokemon
        for(int i = 0; i < 100; i++) {
            System.out.println();
        }
        consoleTextManager.playerInfo(player);
        System.out.println(enemy.toString() + "\n");
        // Si el player es rango y el enemy es cuerpo a cuerpo, el player empieza con turn()
        if(player.getAttackType() == AttackType.RANGE && enemy.getAttackType() == AttackType.MELEE) {
            int i = 0;
            while(enemy.getLives() > 0 && i == 0){
                attack(player, enemy);
                if(enemy.getLives() <= 0) { 
                    i++;
                }
                consoleTextManager.playerInfo(player);
                System.out.println(enemy.toString() + "\n");
                attack(player, enemy);
                if(enemy.getLives() <= 0) {
                    i++;
                }
                consoleTextManager.playerInfo(player);
                System.out.println(enemy.toString() + "\n");
                attack(enemy, player);
            }
        } else if(player.getAttackType() == AttackType.MELEE && enemy.getAttackType() == AttackType.RANGE) {
            int i = 0;
            while(player.getLives() > 0 && i == 0){
                attack(enemy, player);
                if(player.getLives() <= 0) {
                    i++;
                }
                consoleTextManager.playerInfo(player);
                System.out.println(enemy.toString() + "\n");
                attack(enemy, player);
                if(player.getLives() <= 0) {
                    i++;
                }
                consoleTextManager.playerInfo(player);
                System.out.println(enemy.toString() + "\n");
                attack(player, enemy);
                i++;
            }
        } else {
            if(calculator.getRandomDoubleBetweenRange(0, 2) <= 1) {
                attack(player, enemy);
                attack(enemy, player);
            }
            else{
                attack(enemy, player);
                attack(player, enemy);
            }
        }
    }

    private void attack(Entity attacker, Entity attaked) {   
        if(attacker instanceof PlayerComponent) {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Curarte");
            switch(scanner.nextInt()) {
                case 1:
                    attaked.setLives(calculator.calculateLives(attacker, attaked));
                    attaked.getCurrentState().attack(attacker, attaked);
                    consoleTextManager.writeText(attacker, attaked, Texto.ATTACK);
                    break;
                case 2:
                    attacker.setLives(2);
                    System.out.println("Te has curado 2 puntos de vida");
                    // Aquí va el código para curar al jugador
                    break;
                    //!(espada 0(armadura 10(player 2)) = 12 -> 12 + 2 -> (espada 14(armadura 10(player 2)) = 26 
                default:
                    attaked.setLives(calculator.calculateLives(attacker, attaked));
                    attaked.getCurrentState().attack(attacker, attaked);
                    consoleTextManager.writeText(attacker, attaked, Texto.ATTACK);
                    break;
            }
        }else if(attacker instanceof AbstractEnemy) {
            // attaked.heal(-attacker.getPower());
            // attaked.getCurrentState().attack(attacker, attaked);            
            // consoleTextManager.writeText(attacker, attaked, Texto.ATTACK);
        }
        //al Text manager para mostrar el ataque
        // al show para los estados
    }
}