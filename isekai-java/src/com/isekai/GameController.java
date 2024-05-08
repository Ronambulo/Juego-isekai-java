package com.isekai;
import java.util.ArrayList;
import java.util.Scanner;
import com.isekai.entities.*;
import com.isekai.entities.decorator.AbstractPlayerDecorator;
import com.isekai.entities.state.DeadState;

public class GameController {
    private static GameController instance;
    public final String DEFAULT_PLAYER_NAME = "Javi";

    private WorldAbstractFactory world1Factory = new World1Factory();
    private WorldAbstractFactory world2Factory = new World2Factory();
    private PlayerFactory playerFactory = new PlayerFactory();
    private ConsoleTextManager consoleTextManager = ConsoleTextManager.getInstance();
    private PlayerComponent player;
    private Calculator calculator = Calculator.getInstance();
    private String playerName;

    private ArrayList<Entity> world1Enemies;
    private ArrayList<Entity> world2Enemies;

    private Scanner scanner = new Scanner(System.in);
    private Boolean gameOver = false;
    private Integer currentWorld = 1;
    private Integer numberOfCures = 3;

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
        System.out.println("Indica tu nombre para comenzar: ");
        playerName = scanner.nextLine();   
        if(playerName.isEmpty()) {
            playerName = DEFAULT_PLAYER_NAME;
        }

        consoleTextManager.writeText(Texto.INTRODUCTION);
        System.out.println("\n\n");
        //seleccionar jugador
        player = SelectPlayer();
        //Una vez seleccionado, podremos modificar el nombre
        player.setName(playerName);

        //crear los arrays de los enemigos de cada mundo
        spawnEnemies();
        System.out.println();

        //Lógica del juego
        gameLogic(world1Enemies);
        currentWorld = 2;
        gameLogic(world2Enemies);
 

        if(player.getLives() <= 0) {
            System.out.println("Estado del jugador: ");
            player.getCurrentState().show(player);
            gameOver = true;
        }    
        if(gameOver) {
            consoleTextManager.writeText(Texto.LOOSE);
        } else {
            consoleTextManager.writeText(Texto.WIN);
        }
        
    }

    private PlayerComponent SelectPlayer(){
        PlayerType playerType;
        System.out.println("Elije tu clase: ");
        System.out.println("+----------------------------------------------------+");
        player = playerFactory.createPlayer(PlayerType.PALADIN);
        System.out.println("| 1. Paladin     - MELEE    Vida: " + player.getLives() + "      Daño: " + player.getPower() + "   |");
        player = playerFactory.createPlayer(PlayerType.WIZARD);
        System.out.println("| 2. Mago        - RANGO    Vida: " + player.getLives() + "      Daño: " + player.getPower() + "   |");
        player = playerFactory.createPlayer(PlayerType.BERSERK);
        System.out.println("| 3. Berserk     - MELEE    Vida: " + player.getLives() + "      Daño: " + player.getPower() + "   |");
        player = playerFactory.createPlayer(PlayerType.KNIGHT);
        System.out.println("| 4. Caballero   - MELEE    Vida: " + player.getLives() + "      Daño: " + player.getPower() + "   |");
        player = playerFactory.createPlayer(PlayerType.ARCHER);
        System.out.println("| 5. Arquero     - RANGO    Vida: " + player.getLives() + "      Daño: " + player.getPower() + "   |");
        System.out.println("+----------------------------------------------------+\n");

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
                            numberOfCures +=1;
                            // reseteamos el contador de turnos
                            turns = 0;
                        }
                    }
                }
                System.out.println("¡¡¡¡" + enemy.getName() + " HA MUERTO!!!!\n");
            }           
        
            //si al terminar el bucle, no hay enemigos vivos, se sale del bucle
            if(enemiesAlive == 0) break;
        }
    }

    private void turn(Entity player, Entity enemy) {
        // Llamar a los estados y al toString de ambos para tipico nombre, vida, etc de pokemon


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

    private void attack(Entity attacker, Entity attaked) {   
        if(attacker instanceof AbstractPlayerDecorator) {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Curarte (" + numberOfCures + ")");
            switch(scanner.nextInt()) {
                case 1:
                    clearScreen(40);
                    attaked.setLives(calculator.calculateLives(attacker, attaked));
                    consoleTextManager.writeText(attacker, attaked, Texto.ATTACK);
                    break;
                case 2:
                    clearScreen(40);
                    if(numberOfCures > 0){
                        if(currentWorld == 1)
                            attacker.modifyHealth((int)Calculator.getRandomDoubleBetweenRange(5, 10));
                        else
                            attacker.modifyHealth((int)Calculator.getRandomDoubleBetweenRange(5, 10) * World.LEVEL2.getComplexFactor());
                        
                        consoleTextManager.writeText(attacker, Texto.HEAL);
                        numberOfCures -= 1;
                    }
                    else{
                        System.out.println("No tienes pociones de curación");
                    }
                    
                    // Aquí va el código para curar al jugador
                    break;
                default:
                    clearScreen(40);
                    attaked.setLives(calculator.calculateLives(attacker, attaked));
                    consoleTextManager.writeText(attacker, attaked, Texto.ATTACK);
                    break;
            }
            if(attaked.getLives() > 0) {
                System.out.println("Estado del Enemigo:");
                attaked.getCurrentState().attack(attacker, attaked); 
            } 

        }else if(attacker instanceof AbstractEnemy) {              
            if(player.getLives() > 0) {
                attaked.modifyHealth(-attacker.getPower());
                System.out.println("Estado del jugador:");
                attaked.getCurrentState().attack(attacker, attaked); 
                consoleTextManager.writeText(attacker, attaked, Texto.ATTACK);
            }
        }
        //al Text manager para mostrar el ataque
        // al show para los estados

        if(attacker instanceof AbstractPlayerDecorator) {
            displayState(attacker, attaked);
        } else {
            displayState(attaked, attacker);
        }
    }

    public void clearScreen(Integer n){
        for(int i = 0; i < n; i++) {
            System.out.println();
        }
    }
    private void displayState(Entity player, Entity enemy){
        System.out.println("+---------------------------------------+");
        consoleTextManager.playerInfo(player, playerName);
        System.out.println("| " + enemy.toString() + " \t|");
        System.out.println("+---------------------------------------+");
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
        System.out.println("RANDOM ATTACKS\n");
        if(Calculator.getRandomDoubleBetweenRange(0, 2) <= 1) {
            // System.out.println("¡Atacas primero!");
            attack(player, enemy);
            if(enemyIsAlive(enemy)) attack(enemy, player);
        }
        else{
            // System.out.println("TURNO: \n ");
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