package com.isekai;
import java.util.ArrayList;
import java.util.Scanner;
import com.isekai.entities.*;
import com.isekai.entities.decorator.*;
import com.isekai.entities.enemies.*;
import com.isekai.entities.enemies.dragon.Dragon;
import com.isekai.entities.strategy.*;

public class GameController {
    private static GameController instance;
    public static final String DEFAULT_PLAYER_NAME = "Javi";

    private WorldAbstractFactory world1Factory = new World1Factory();
    private WorldAbstractFactory world2Factory = new World2Factory();
    private PlayerFactory playerFactory = new PlayerFactory();
    private ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();
    private Calculator calculator = Calculator.getInstance();
    private AbstractPlayerComponent player;
    private String playerName;

    private ArrayList<Entity> world1Enemies;
    private ArrayList<Entity> world2Enemies;
    private Entity dragon = world1Factory.createDragon();
    
    private Scanner scanner = new Scanner(System.in);

    private Boolean gameOver = false;
    private Integer currentWorld;

    //ESTRATEGIAS (las guardamos para no tener que instanciarlas cada vez que se llaman)
    private AttackActionStrategy attackActionStrategy = new AttackActionStrategy();
    private HealActionStrategy healActionStrategy = new HealActionStrategy();
    private InvisibilityActionStrategy invisibilityActionStrategy = new InvisibilityActionStrategy();
    private ImproveStatsAction improveStatsActionStrategy = new ImproveStatsAction();

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

        consoleTextManager.writeText(Text.INTRODUCTION);
        System.out.println("\n\n");
        //seleccionar jugador
        player = playerFactory.createPlayer(consoleTextManager.playerSelection());
        //Una vez seleccionado, podremos modificar el nombre
        player.setName(playerName);

        //crear los arrays de los enemigos de cada mundo
        spawnEnemies();
        System.out.println();


        while(enemyIsAlive(dragon) && playerIsAlive()){
            //Lógica del juego
            currentWorld = 1;
            gameLogic(world1Enemies);
            currentWorld = 2;
            player.setLives(1000);
            gameLogic(world2Enemies);
            System.out.println();

            consoleTextManager.clearScreen(50);
            System.out.println("¿DESEAS COMBATIR AL BOSS FINAL? (S/N)");
            if(scanner.nextLine().toLowerCase().equals("s")) {
                gameLogic(new ArrayList<Entity>(){{add(dragon);}});
            }   

            spawnEnemies();
        }


        if(!playerIsAlive()) {
            System.out.println("Estado del jugador: ");
            player.getCurrentState().show(player);
            gameOver = true;
        }    
        if(gameOver) {
            consoleTextManager.clearScreen(50);
            consoleTextManager.writeText(Text.LOOSE);
        } else {
            consoleTextManager.clearScreen(50);
            consoleTextManager.writeText(Text.WIN);
        }
        
        scanner.close();
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

            //recorro el array de enemigos
            for(Entity enemy: listEnemies){
                if(!playerIsAlive() || !enemyIsAlive(enemy)) break;

                System.out.println("¡¡¡¡" + enemy.toString() + " HA APARECIDO!!!!");

                // Compruebo si está vivo el enemigo
                if(enemyIsAlive(enemy)) enemiesAlive++;

                while(enemyIsAlive(enemy) && playerIsAlive()){                
                    //si el jugador muere, se sale del bucle
                    if(!playerIsAlive()) {
                        gameOver = true;
                        //que se salga directamente, porque sino sigue haciéndolo hasta que recorre todo el array 
                    } else{
                        turn(player, enemy);
                    }
                }
                System.out.println(ConsoleTextManager.ANSI_RED + "¡¡¡¡" + enemy.getName() + " HA MUERTO!!!!\n" + ConsoleTextManager.ANSI_RESET);
                player.setArcaneKnowledge(calculator.calculateArcaneKnowledge(player, enemy));
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
            }// Si el player es cuerpo a cuerpo y el enemy es rango, el enemy empieza con turn() 
            else if(player.getAttackType() == AttackType.MELEE && enemy.getAttackType() == AttackType.RANGE) {
                meleeAttackFirst(player, enemy);
            } else {
                //Si no, se hace un ataque aleatorio
                randomAttacks(player, enemy);
            }
        }
    }

    private void attack(Entity attacker, Entity attacked) {
        
        //Mostramos el estado del jugador y del enemigo
        if(attacker instanceof AbstractPlayerDecorator) {
            consoleTextManager.displayState(attacker, attacked);
        } else {
            consoleTextManager.displayState(attacked, attacker);
        }
        
        //Si el atacante es un jugador, se le da la opción de elegir entre atacar, curarse, hacerse invisible o mejorar su nivel de poder
        if(attacker instanceof AbstractPlayerDecorator) {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Curarte ( Coste: 10 de " + ConsoleTextManager.ANSI_BLUE + "■ "+"Conocimiento Arcano" + " ■" + ConsoleTextManager.ANSI_RESET + " )");
            System.out.println("3. Hacer invisible ( Coste: 10 de " + ConsoleTextManager.ANSI_BLUE + "■ "+"Conocimiento Arcano" + " ■" + ConsoleTextManager.ANSI_RESET + " )");
            System.out.println("4. Mejorar tu nivel de poder ( Coste: 100 de " + ConsoleTextManager.ANSI_BLUE + "■ "+"Conocimiento Arcano" + " ■" + ConsoleTextManager.ANSI_RESET + " )");
            //leemos la opción, asignamos la estrategia y la ejecutamos
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
                case 4:
                    consoleTextManager.clearScreen(40);
                    attacker.setContextStrategy(improveStatsActionStrategy);
                    attacker.getContextStrategy().performAction(20, attacked);
                    break;
                default:
                    consoleTextManager.clearScreen(40);
                    attacker.setContextStrategy(attackActionStrategy);
                    attacker.getContextStrategy().performAction(attacker, attacked);
                    break;
            }
            //limpiamos buffer, ya que se come el salto de línea
            scanner.nextLine();
            
            //si el atacado sigue vivo, se le ataca
            if(attacked.getLives() > 0) {
                attacked.getCurrentState().attack(attacker, attacked); 
            } 

        //Si el atacante es un enemigo, este ataca al jugador
        }else if(attacker instanceof AbstractEnemy) {              
            if(player.getLives() > 0) {
                //Si el jugador es invisible, no se le puede atacar
                if(attacked.getContextStrategy() instanceof InvisibilityActionStrategy){
                    System.out.println("¡¡¡¡" + attacked.getName() + " es invisible, " + attacker.getName() + " es atacado" + "!!!!");
                    attacked.getContextStrategy().performAction(attacked, attacker);
                }
                //Si no, se le ataca
                else{
                    attacker.getContextStrategy().performAction(attacker, attacked); 
                }
            }
        }
    }

    //ATAQUES
    //Si el jugador es rango y el enemigo cuerpo a cuerpo, el jugador ataca primero
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

    //Si el jugador es cuerpo a cuerpo y el enemigo rango, el enemigo ataca primero
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
   
    //Ataques aleatorios si ambos son del mismo tipo de ataque, se elige aleatoriamente
    private void randomAttacks(Entity player, Entity enemy){
        //si el enemigo es un dragón, ataca siempre el jugador primero
        if((Calculator.getRandomDoubleBetweenRange(0, 2) <= 1) || enemy instanceof Dragon) {
            attack(player, enemy);
            if(enemyIsAlive(enemy)) attack(enemy, player);
        }
        else{
            attack(enemy, player);
            if(playerIsAlive()) attack(player, enemy);
        }
    }
    
    //comprobaciones de si el enemigo y el jugador están vivos
    private Boolean playerIsAlive(){
        return this.player.getLives() > 0;
    }
    private Boolean enemyIsAlive(Entity enemy){
        return enemy.getLives() > 0;
    }
    
}