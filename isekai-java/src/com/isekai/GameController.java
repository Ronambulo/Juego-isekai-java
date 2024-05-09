package com.isekai;
import java.util.ArrayList;
import java.util.Scanner;
import com.isekai.entities.*;
import com.isekai.entities.decorator.AbstractPlayerDecorator;
import com.isekai.entities.strategy.*;

public class GameController {
    private static GameController instance;
    public static final String DEFAULT_PLAYER_NAME = "Javi";

    private WorldAbstractFactory world1Factory = new World1Factory();
    private WorldAbstractFactory world2Factory = new World2Factory();
    private PlayerFactory playerFactory = new PlayerFactory();
    private ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();
    private PlayerComponent player;
    private String playerName;

    private ArrayList<Entity> world1Enemies;
    private ArrayList<Entity> world2Enemies;

    private Scanner scanner = new Scanner(System.in);
    private Boolean gameOver = false;
    private Integer currentWorld = 1;

    //ESTRATEGIAS
    private AttackActionStrategy attackActionStrategy = new AttackActionStrategy();
    private HealActionStrategy healActionStrategy = new HealActionStrategy();
    private InvisibilityActionStrategy invisibilityActionStrategy = new InvisibilityActionStrategy();

    public static GameController getInstance() {
        if(instance == null) {
            instance = new GameController();
        }
        return instance;
    } 

    public void play() {
        System.out.println("Indica tu nombre para comenzar: ");
        playerName = scanner.nextLine();   
        if(playerName.isEmpty()) playerName = GameController.DEFAULT_PLAYER_NAME;

        consoleTextManager.writeText(Texto.INTRODUCTION);
        System.out.println("\n\n");
        //seleccionar jugador
        player = playerFactory.createPlayer(consoleTextManager.playerSelection());
        //Una vez seleccionado, podremos modificar el nombre
        player.setName(playerName);

        //crear los arrays de los enemigos de cada mundo
        spawnEnemies();
        System.out.println();

        //Lógica del juego
        gameLogic(world1Enemies);
        currentWorld = 2;
        // player.setLives(1000);
        gameLogic(world2Enemies);
 

        if(!playerIsAlive()) {
            System.out.println("Estado del jugador: ");
            player.getCurrentState().show(player);
            gameOver = true;
        }    
        if(gameOver) {
            consoleTextManager.clearScreen(50);
            consoleTextManager.writeText(Texto.LOOSE);
        } else {
            consoleTextManager.clearScreen(50);
            consoleTextManager.writeText(Texto.WIN);
        }
        
    }

    private Entity spawnRandomEnemy(WorldAbstractFactory factory) {
        return factory.createRandomEnemy();
    }

    private void spawnEnemies() {
        this.world1Enemies = new ArrayList<Entity>();
        this.world2Enemies = new ArrayList<Entity>();

        for(int i = 0; i < 10; i++) {
            this.world1Enemies.add(spawnRandomEnemy(this.world1Factory));
            this.world2Enemies.add(spawnRandomEnemy(this.world2Factory));
        }
    }

    //función para generar la lógica del juego
    public void gameLogic(ArrayList<Entity> listEnemies){
       //Mientras el jugador no esté muerto y el juego no haya terminado
       while(playerIsAlive() && !gameOver) {
            //inicializo los enemigos  a 0
            Integer enemiesAlive = 0;
            Integer turns = 0;

            for(Entity enemy: listEnemies){
                if(!playerIsAlive() || !enemyIsAlive(enemy)) break;

                System.out.println("¡¡¡¡" + enemy.toString() + " HA APARECIDO!!!!");
                // consoleTextManager.printEnemy(enemy);

                //compruebo si está vivo el enemigo
                if(enemy.getLives() > 0) enemiesAlive++;

                while(enemy.getLives() > 0 && player.getLives() > 0){                
                    //si el jugador muere, se sale del bucle
                    if(!playerIsAlive()) {
                        gameOver = true;
                        //que se salga directamente, porque sino sigue haciéndolo hasta que recorre todo el array 
                    } else{
                        turn(player, enemy);

                        //PARA LAS CURAS
                        turns++;
                        if(turns==3){
                            player.setNumberOfCures(player.getNumberOfCures() + 1);
                            // reseteamos el contador de turnos
                            turns = 0;
                        }
                    }
                }
                System.out.println(ConsoleTextManager.ANSI_RED + "¡¡¡¡" + enemy.getName() + " HA MUERTO!!!!\n" + ConsoleTextManager.ANSI_RESET);
            }           
        
            //si al terminar el bucle, no hay enemigos vivos, se sale del bucle
            if(enemiesAlive == 0) break;
        }
    }

    private void turn(Entity player, Entity enemy) {
        if(playerIsAlive() && enemyIsAlive(enemy)){
            // Si el player es rango y el enemy es cuerpo a cuerpo, el player empieza con turn()
            if(player.getAttackType() == AttackType.RANGE && enemy.getAttackType() == AttackType.MELEE) {
                rangeAttackFirst(player, enemy);
            } else if(player.getAttackType() == AttackType.MELEE && enemy.getAttackType() == AttackType.RANGE) {
                meleeAttackFirst(player, enemy);
            } else {
                randomAttacks(player, enemy);
            }
        }
    }

    private void attack(Entity attacker, Entity attacked) {
        
        if(attacker instanceof AbstractPlayerDecorator) {
            consoleTextManager.displayState(attacker, attacked);
        } else {
            consoleTextManager.displayState(attacked, attacker);
        }
        
        if(attacker instanceof AbstractPlayerDecorator) {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Curarte (Contienes " + attacker.getNumberOfCures() + " curas)");
            System.out.println("3. Hacer invisible ( Coste: 10 de " + ConsoleTextManager.ANSI_BLUE + "■ "+"Conocimiento Arcano" + " ■" + ConsoleTextManager.ANSI_RESET + " )");
            switch(scanner.nextInt()) { 
                case 1:
                    consoleTextManager.clearScreen(40);
                    attacker.setContextStrategy(attackActionStrategy);
                    attacker.getContextStrategy().performAction(attacker, attacked);
                    break;
                case 2:
                    consoleTextManager.clearScreen(40);
                    attacker.setContextStrategy(healActionStrategy);
                    attacker.getContextStrategy().performAction(currentWorld, attacker);
                    break;
                case 3:
                    consoleTextManager.clearScreen(40);
                    attacker.setContextStrategy(invisibilityActionStrategy);
                    attacker.getContextStrategy().performAction(attacker, attacked);
                    break;
                default:
                    consoleTextManager.clearScreen(40);
                    attacker.setContextStrategy(attackActionStrategy);
                    attacker.getContextStrategy().performAction(attacker, attacked);
                    break;
            }
            if(attacked.getLives() > 0) {
                attacked.getCurrentState().attack(attacker, attacked); 
            } 

        }else if(attacker instanceof AbstractEnemy) {              
            if(player.getLives() > 0) {
                if(attacked.getContextStrategy() instanceof InvisibilityActionStrategy){
                    System.out.println("¡¡¡¡" + attacked.getName() + " es invisible, " + attacker.getName() + " es atacado" + "!!!!");
                    attacked.getContextStrategy().performAction(attacked, attacker);
                }
                else{
                    attacked.modifyHealth(-attacker.getPower());
                    attacked.getCurrentState().attack(attacker, attacked); 
                    consoleTextManager.writeText(attacker, attacked, Texto.ATTACK);
                }
            }
        }
    }
    //ATAQUES
    private void rangeAttackFirst(Entity player, Entity enemy){
        System.out.println("¡Te toca atacar a ti primero!\n");

        while(enemy.getLives() > 0 && enemy.getLives() > 0){
            attack(player, enemy);
            if(!playerIsAlive() || !enemyIsAlive(enemy)) break;
            attack(player, enemy);
            if(!playerIsAlive() || !enemyIsAlive(enemy)) break;
            attack(enemy, player);
        }
    }

    private void meleeAttackFirst(Entity player, Entity enemy){
        System.out.println("MELEE ATTACK FIRST\n");
        while(player.getLives() > 0 && enemy.getLives() > 0){        
            attack(enemy, player);
            if(!playerIsAlive() || !enemyIsAlive(enemy)) break;
            attack(enemy, player);
            if(!playerIsAlive() || !enemyIsAlive(enemy)) break; 
            attack(player, enemy);
        }
    }
    
    private void randomAttacks(Entity player, Entity enemy){
        if(Calculator.getRandomDoubleBetweenRange(0, 2) <= 1) {
            attack(player, enemy);
            if(enemyIsAlive(enemy)) attack(enemy, player);
        }
        else{
            attack(enemy, player);
            if(playerIsAlive()) attack(player, enemy);
        }
    }
    
    private Boolean playerIsAlive(){
        return this.player.getLives() > 0;
    }
    private Boolean enemyIsAlive(Entity enemy){
        return enemy.getLives() > 0;
    }
    
}