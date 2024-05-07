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

        //
        spawnEnemies();
        System.out.println();

        //Mientras el jugador no esté muerto y el juego no haya terminado
        while(!(player.getCurrentState() instanceof DeadState) && !gameOver) {
            world1Enemies.forEach(enemy -> {
                while(enemy.getLives() > 0 && player.getLives() > 0){  
                    if(player.getLives() <= 0) {
                        gameOver = true;
                    }  
                    turn(player, enemy);
                }
     
            });
        }
        while(!(player.getCurrentState() instanceof DeadState) && !gameOver) {
            world2Enemies.forEach(enemy -> {
                while(enemy.getLives() > 0 && player.getLives() > 0){  
                    if(player.getLives() <= 0) {
                        gameOver = true;
                    }  
                    turn(player, enemy);
                }
     
            });
        }

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
        System.out.println("+-------------------------------------------------+");
        System.out.println("| 1. Paladin     - MELEE    Vida: 25    Daño: 8   |");
        System.out.println("| 2. Mago        - RANGO    Vida: 8     Daño: 15  |");
        System.out.println("| 3. Berserk     - MELEE    Vida: 8     Daño: 20  |");
        System.out.println("| 4. Caballero   - MELEE    Vida: 10    Daño: 10  |");
        System.out.println("| 5. Arquero     - RANGO    Vida: 8     Daño: 12  |");
        System.out.println("+-------------------------------------------------+\n");

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
        return factory.createBee();
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
        //clearScreen(50);
        System.out.println("-------------x-------------");

        // Mostramos el estado del jugador y del enemigo
        displayState(player, enemy);

        // Si el player es rango y el enemy es cuerpo a cuerpo, el player empieza con turn()
        if(player.getAttackType() == AttackType.RANGE && enemy.getAttackType() == AttackType.MELEE) {
            rangeAttackFirst(player, enemy);
        } else if(player.getAttackType() == AttackType.MELEE && enemy.getAttackType() == AttackType.RANGE) {
            meleeAttackFirst(player, enemy);
        } else {
            randomAttacks(player, enemy);
        }
    }

    private void attack(Entity attacker, Entity attaked) {   

        if(attacker instanceof AbstractPlayerDecorator) {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Curarte");
            switch(scanner.nextInt()) {
                case 1:
                    attaked.setLives(calculator.calculateLives(attacker, attaked));
                    consoleTextManager.writeText(attacker, attaked, Texto.ATTACK);
                    break;
                case 2:
                    attacker.modifyHealth((int)Calculator.getRandomDoubleBetweenRange(5, 10));
                    consoleTextManager.writeText(attacker, Texto.HEAL);
                    // Aquí va el código para curar al jugador
                    break;
                default:
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
        int i = 0;
        while(enemy.getLives() > 0 && i == 0){
            attack(player, enemy);
            if(enemy.getLives() <= 0 || player.getLives() <= 0) { 
                i++;
            }
            displayState(player, enemy);
            attack(player, enemy);
            if(enemy.getLives() <= 0 || player.getLives() <= 0) {
                i++;
            }
            displayState(player, enemy);
            attack(enemy, player);
        }
    }

    private void meleeAttackFirst(Entity player, Entity enemy){
        int i = 0;
        while(player.getLives() > 0 && i == 0){
            attack(enemy, player);
            if(player.getLives() <= 0) {
                i++;
            }
            displayState(player, enemy);
            attack(enemy, player);
            if(player.getLives() <= 0 || player.getLives() <= 0) {
                i++;
            }
            displayState(player, enemy);
            attack(player, enemy);
            i++;
        }
    }
    
    private void randomAttacks(Entity player, Entity enemy){
        if(Calculator.getRandomDoubleBetweenRange(0, 2) <= 1) {
            attack(player, enemy);
            attack(enemy, player);
        }
        else{
            attack(enemy, player);
            attack(player, enemy);
        }
    }
    
    // private boolean performAttack(Entity attacker, Entity attacked){
    //     attack(attacker, attacked);
    //     displayState(attacked, attacker);
    //     return attacked.getLives() <= 0;
    // }


}