package com.isekai;
import java.util.Scanner;
import java.util.concurrent.*;
import com.isekai.entities.*;
import com.isekai.entities.enemies.slime.Slime;
import com.isekai.entities.enemies.slime.SlimeColor;

public class ConsoleTextManager {

    //COLORES ANSI (unicode)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BROWN = "\u001B[33m";
    public static final String ANSI_GREY = "\u001B[37m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private Text numberToText;
    private Entity entityAttack;
    private Entity entityDefend;
    private static ConsoleTextManager instance;
    private Scanner scanner = new Scanner(System.in);

    private ConsoleTextManager(){
        super();
    }

    public static ConsoleTextManager getInstance(){
        if(instance == null){
            instance = new ConsoleTextManager();
        }
        return instance;
    }

    public void writeText( Text dialogo){
        this.numberToText = dialogo;
        numberToText();
    }

    public void writeText(Entity entityAttack, Text dialogo){
        this.numberToText = dialogo;
        this.entityAttack = entityAttack;
        numberToText();
    }

    public void writeText(Entity entityAttack, Entity entityDefend, Text dialogo){
        this.numberToText = dialogo;
        this.entityAttack = entityAttack;
        this.entityDefend = entityDefend;
        numberToText();
    }

    private void numberToText(){
        switch (this.numberToText.getNumber()) {
            case 1: //introduccion
                //! DESCOMENTAR PARA USAR    (por cierto enrique tienes que explicarme el numberToText)
                // typeWriter("Bienvenido a Isekai, el juego de rol por consola, donde tu eres el protagonista y debes enfrentarte a los monstruos de este mundo para poder volver al tuyo.", 50);
                // waitSeconds(1);
                // typeWriter("Ibas caminando por la calle cuando de repente te desmayaste y al despertar te encontrabas en un lugar desconocido...\n", 50);
                // waitSeconds(1);
                // typeWriter("Un anciano (•̅灬•̅ ) te explica que estas en un mundo paralelo y que para volver al tuyo debes derrotar a los monstruos que habitan en este mundo....", 50);
                // waitSeconds(1);
                // typeWriter("El anciano te da a elegir entre 5 clases, cada uno con sus propias armas, elige sabiamente.", 50);
                // waitSeconds(2);
                break;
            case 2: //Ataque
                System.out.println("--------" + this.entityAttack.getName() + " ataca a " + this.entityDefend.getName() + " con " + this.entityAttack.getPower() + " de daño" + "--------\n" );
                break;

            case 3: //Curacion
                System.out.println("--------"  + this.entityAttack.getName() + " se ha curado y ahora tiene " + this.entityAttack.getLives() + " de vida" + "--------\n");
                break;

            case 4: //Defensa
                System.out.println(this.entityAttack.getName() + " se defiende");
                break;
            case 5: //Muerte
                System.out.println(this.entityAttack.getName() + " ha muerto");
                break;
            case 6: //Victoria
                System.out.println(ConsoleTextManager.ANSI_GREEN + "██╗  ██╗ █████╗ ███████╗     ██████╗  █████╗ ███╗   ██╗ █████╗ ██████╗  ██████╗ ");
                System.out.println(                              "██║  ██║██╔══██╗██╔════╝    ██╔════╝ ██╔══██╗████╗  ██║██╔══██╗██╔══██╗██╔═══██╗");
                System.out.println(                              "███████║███████║███████╗    ██║  ███╗███████║██╔██╗ ██║███████║██║  ██║██║   ██║");
                System.out.println(                              "██╔══██║██╔══██║╚════██║    ██║   ██║██╔══██║██║╚██╗██║██╔══██║██║  ██║██║   ██║");
                System.out.println(                              "██║  ██║██║  ██║███████║    ╚██████╔╝██║  ██║██║ ╚████║██║  ██║██████╔╝╚██████╔╝");
                System.out.println(                                "╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═════╝ ╚═════╝ " + ConsoleTextManager.ANSI_RESET);                
                break;
            case 7: //Derrota
                System.out.println(ConsoleTextManager.ANSI_RED + " ██╗  ██╗ █████╗ ███████╗    ███╗   ███╗██╗   ██╗███████╗██████╗ ████████╗ ██████╗ ");
                System.out.println(                            " ██║  ██║██╔══██╗██╔════╝    ████╗ ████║██║   ██║██╔════╝██╔══██╗╚══██╔══╝██╔═══██╗");
                System.out.println(                            " ███████║███████║███████╗    ██╔████╔██║██║   ██║█████╗  ██████╔╝   ██║   ██║   ██║");
                System.out.println(                            " ██╔══██║██╔══██║╚════██║    ██║╚██╔╝██║██║   ██║██╔══╝  ██╔══██╗   ██║   ██║   ██║");
                System.out.println(                            " ██║  ██║██║  ██║███████║    ██║ ╚═╝ ██║╚██████╔╝███████╗██║  ██║   ██║   ╚██████╔╝");
                System.out.println(                              " ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝    ╚═╝     ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝ " + ConsoleTextManager.ANSI_RESET);
                break;
            default:
                break;
        }
    }

    public void typeWriter(String message, long delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // Mueve a la siguiente línea después de terminar la frase
    }
    
    public void waitSeconds(Integer seconds) {
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch(InterruptedException e){
                e.printStackTrace();
        } 
    }

    public void playerInfo(Entity player){
        System.out.println("| " + player.getName() + ConsoleTextManager.ANSI_YELLOW + "\t\tPoder: " + player.getPower() + ConsoleTextManager.ANSI_RED + " Vida: " + player.getLives() + ConsoleTextManager.ANSI_RESET + " \t|");
    }

    public void printEnemy(Entity enemy){
        switch (enemy.getName()) {
            case "Wolf":
                printWolf();
                break;
            case "Ogre":
                printOgre();
                break;
            case "Bee":
                printBee();
                break;
            case "Goat":
                printGoat();
                break;
            case "Slime":
                if( ((Slime)enemy).getModification().equals(SlimeColor.RED.getColor()) )
                    printSlimeRed();
                else if( ((Slime)enemy).getModification().equals(SlimeColor.BLUE.getColor()) )
                    printSlimeBlue();
                else if( ((Slime)enemy).getModification().equals(SlimeColor.RAINBOW.getColor()) )
                    printSlimeRainbow();
                break;
            case "Dragon":
                printDragon();
                break;
            default:
                break;
        }
    }

    public PlayerType playerSelection(){
        System.out.println("Elije tu clase: ");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| 1. Paladin     - MELEE    Vida: " + 60 + "      Daño: " + 14 + "   |");
        System.out.println("| 2. Mago        - RANGO    Vida: " + 30 + "      Daño: " + 18 + "   |");
        System.out.println("| 3. Berserk     - MELEE    Vida: " + 40 + "      Daño: " + 21 + "   |");
        System.out.println("| 4. Caballero   - MELEE    Vida: " + 50 + "      Daño: " + 16 + "   |");
        System.out.println("| 5. Arquero     - RANGO    Vida: " + 40 + "      Daño: " + 16 + "   |");
        System.out.println("+----------------------------------------------------+\n");

        PlayerType playerType;

        switch (scanner.nextInt()) {
            case 1:
                playerType = PlayerType.PALADIN;
                System.out.println("¡Has elegido Paladin!");
                printPaladin();
                break;
            case 2:
                playerType = PlayerType.WIZARD;
                System.out.println("¡Has elegido Mago!");
                printWizard();
                break;
            case 3:
                playerType = PlayerType.BERSERK;
                System.out.println("¡Has elegido Berserk!");
                printBerserk();
                break;
            case 4:
                playerType = PlayerType.KNIGHT;
                System.out.println("¡Has elegido Caballero!");
                printKnight();
                break;
            case 5:
                playerType = PlayerType.ARCHER;
                System.out.println("¡Has elegido Arquero!");
                printArcher();
                break;
            default:
                playerType = PlayerType.KNIGHT;
                System.out.println("Al no elegir nada, te asignamos Caballero por defecto, pringao.");
                printKnight();
                break;
        }

        waitSeconds(6);
        clearScreen(40);
        return playerType;
    }

    public void clearScreen(Integer n){
        for(int i = 0; i < n; i++) {
            System.out.println();
        }
    }   

    public void displayState(Entity player, Entity enemy){
        printEnemy(enemy);
        System.out.println("+---------------------------------------+");
        playerInfo(player);
        System.out.println("| " + ConsoleTextManager.ANSI_BLUE +  "Conocimiento Arcano: " + ((AbstractPlayerComponent)player).getArcaneKnowledge() + ConsoleTextManager.ANSI_RESET +  "\t\t|");
        System.out.print("| ");
        player.getCurrentState().show(player);
        System.out.println("\t\t|");
        System.out.println("+---------------------------------------+");
        System.out.println("| " + enemy.toString() + " \t|");
        System.out.print("| ");
        enemy.getCurrentState().show(enemy);
        System.out.println("\t\t|");
        System.out.println("+---------------------------------------+");
    }


    private void printWolf() {
        System.out.println(ConsoleTextManager.ANSI_GREY + "                              __");
        System.out.println("                            .d$$b");
        System.out.println("                          .' TO$;\\");
        System.out.println("                         /  : TP._;");
        System.out.println("                        / _.;  :Tb|");
        System.out.println("                       /   /   ;j$j");
        System.out.println("                   _.-\"       d$$$$");
        System.out.println("                 .' ..       d$$$$;");
        System.out.println("                /  /P'      d$$$$P. |\\");
        System.out.println("               /   \"      .d$$$P' |\\^\"l");
        System.out.println("             .'           `T$P^\"\"\"\"\"  :");
        System.out.println("         ._.'      _.'                ;");
        System.out.println("      `-.-\".-'-' ._.       _.-\"    .-\"");
        System.out.println("    `.-\" _____  ._              .-\"");
        System.out.println("   -(.g$$$$$$$b.              .'");
        System.out.println("     \"\"^^T$$$P^)            .(:");
        System.out.println("       _/  -\"  /.'         /:/;");
        System.out.println("    ._.'-'`-'  \")/         /;/;");
        System.out.println(" `-.-\"..--\"\"   \" /         /  ;");
        System.out.println(".-\" ..--\"\"        -'          :");
        System.out.println("..--\"\"--.-\"         (\\      .-(\\");
        System.out.println("  ..--\"\"              `\\-(\\/;`");
        System.out.println("    _.                      :");
        System.out.println("                            ;`-");
        System.out.println("                           :\\");
        System.out.println("                           ;  " + ConsoleTextManager.ANSI_RESET);
    }
    private void printOgre() {
        System.out.println(ConsoleTextManager.ANSI_GREEN + "                           __,='`````'=/__");
        System.out.println("                          '//  (o) \\(o) \\ `'         _,-,");
        System.out.println("                          //|     ,_)   (`\\      ,-'`_,-\\");
        System.out.println("                        ,-~~~\\  `'==='  /-,      \\==```` \\__");
        System.out.println("                       /        `----'     `\\     \\       \\/");
        System.out.println("                    ,-`                  ,   \\  ,.-\\       \\");
        System.out.println("                   /      ,               \\,-`\\`_,-`\\_,..--'\\");
        System.out.println("                  ,`    ,/,              ,>,   )     \\--`````\\");
        System.out.println("                  (      `\\`---'`  `-,-'`_,<   \\      \\_,.--'");
        System.out.println("                   `.      `--. _,-'`_,-`  |    \\");
        System.out.println("                    [`-.___   <`_,-'`------(    /");
        System.out.println("                    (`` _,-\\   \\ --`````````|--`");
        System.out.println("                     >-`_,-`\\,-` ,          |");
        System.out.println("                   <`_,'     ,  /\\          /");
        System.out.println("                    `  \\/,-/ `/  \\/`\\_/V\\_/");
        System.out.println("                       (  ._. )    ( .__. )");
        System.out.println("                       |      |    |      |");
        System.out.println("                        \\,---_|    |_---./");
        System.out.println("                        ooOO(_)    (_)OOoo" + ConsoleTextManager.ANSI_RESET);
    }
    private void printBee() {
        System.out.println(ConsoleTextManager.ANSI_YELLOW + "      .-.         .--''-.");
        System.out.println("    .'   '.     /'       `.");
        System.out.println("    '.     '. ,'          |");
        System.out.println(" o    '.o   ,'        _.-'");
        System.out.println("  \\.--./'. /.:. :._:.'");
        System.out.println(" .\\   /'._-':#0: ':#0: ':");
        System.out.println(":(#) (#) :  ':#0: ':#0: ':>#=-");
        System.out.println(" ' ____ .'_.:J0:' :J0:' :'");
        System.out.println("  'V  V'/ | |\":' :'\":'");
        System.out.println("        \\  \\ \\");
        System.out.println("        '  ' '" + ConsoleTextManager.ANSI_RESET);
    }
    private void printGoat() {
        System.out.println("             ,--._,--.");
        System.out.println("           ,'  ,'   ,-`.");
        System.out.println("(`-.__    /  ,'   /");
        System.out.println(" `.   `--'        \\__,--'-.");
        System.out.println("   `--/       ,-.  ______/");
        System.out.println("     (o-.     ,o- /");
        System.out.println("      `. ;        \\");
        System.out.println("       |:          \\");
        System.out.println("      ,'`       ,   \\");
        System.out.println("     (o o ,  --'     :");
        System.out.println("      \\--','.        ;");
        System.out.println("       `;;  :       /");
        System.out.println(" -hrr-  ;'  ;  ,' ,'");
        System.out.println("        ,','  :  '");
        System.out.println("        \\ \\   :");
        System.out.println("         `");
    }
    private void printSlimeRed() {
        System.out.println(ConsoleTextManager.ANSI_RED + "          ██████████          ");
        System.out.println("      ████░░░░░░░░░░████      ");
        System.out.println("    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██    ");
        System.out.println("  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██  ");
        System.out.println("  ██▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██  ");
        System.out.println("██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██");
        System.out.println("██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██");
        System.out.println("██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("██▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒██");
        System.out.println("██▓▓▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▓▓██");
        System.out.println("  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██  ");
        System.out.println("    ██████████████████████    " + ConsoleTextManager.ANSI_RESET);
    }
    private void printSlimeBlue() {
        System.out.println(ConsoleTextManager.ANSI_BLUE + "          ██████████          ");
        System.out.println("      ████░░░░░░░░░░████      ");
        System.out.println("    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██    ");
        System.out.println("  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██  ");
        System.out.println("  ██▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██  ");
        System.out.println("██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██");
        System.out.println("██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██");
        System.out.println("██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("██▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒██");
        System.out.println("██▓▓▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▓▓██");
        System.out.println("  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██  ");
        System.out.println("    ██████████████████████    " + ConsoleTextManager.ANSI_RESET);
    }
    private void printSlimeRainbow() {
        System.out.println(ConsoleTextManager.ANSI_RED +   "          ██████████          ");
        System.out.println(                              "      ████░░░░░░░░░░████      ");
        System.out.println(                              "    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██    ");
        System.out.println(ConsoleTextManager.ANSI_YELLOW +"  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██  ");
        System.out.println(                              "  ██▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██  ");
        System.out.println(ConsoleTextManager.ANSI_GREEN + "██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██");
        System.out.println(                              "██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██");
        System.out.println(                              "██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println(ConsoleTextManager.ANSI_BLUE +  "██▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒██");
        System.out.println(                              "██▓▓▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▓▓██");
        System.out.println(ConsoleTextManager.ANSI_PURPLE +"  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██  ");
        System.out.println(                                "    ██████████████████████    " + ConsoleTextManager.ANSI_RESET);
    }
    private void printDragon(){
        System.out.println(ConsoleTextManager.ANSI_RED + "                                                                                                ░░                                                                          ");
        System.out.println("                                                                    ░░░░▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓░░                                                                    ");
        System.out.println("                                                                ░░░░          ▓▓▒▒▒▒▓▓▓▓██▓▓▒▒▓▓                                                                ");
        System.out.println("                                                                              ▒▒▓▓▓▓▓▓▓▓▓▓▓▓██▒▒                                                                ");
        System.out.println("                                                                        ░░▒▒▓▓▓▓▒▒▓▓▒▒▒▒▓▓▓▓▓▓                                                                  ");
        System.out.println("                                                                    ▒▒▓▓▓▓▒▒▒▒▓▓▓▓▒▒▒▒▓▓▓▓░░                                                                    ");
        System.out.println("                                                                ▒▒▒▒▓▓▒▒▒▒▓▓▓▓▓▓▒▒▒▒▓▓▓▓░░░░                                                                    ");
        System.out.println("                                                          ▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒▓▓▓▓        ░░                  ░░                                            ");
        System.out.println("                                                      ░░▒▒▒▒▒▒▓▓▒▒▒▒▓▓▓▓▒▒▓▓▒▒▓▓▓▓▓▓▒▒░░  ░░  ░░░░  ░░░░        ░░▒▒                                            ");
        System.out.println("                                              ░░░░░░▓▓▒▒▒▒▒▒▓▓▒▒▒▒▓▓▓▓▒▒▓▓▒▒▓▓▓▓██▓▓      ░░░░░░░░░░    ░░░░  ▒▒▓▓▒▒                                            ");
        System.out.println("                                                ▓▓▒▒▒▒▒▒▒▒▓▓▒▒░░▓▓▓▓▓▓▒▒▓▓▒▒▓▓▓▓██▒▒        ░░░░░░░░  ░░  ░░▒▒▓▓▓▓▓▓              ░░                            ");
        System.out.println("                                              ▓▓▒▒▒▒▒▒▒▒▓▓░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░        ░░░░░░░░  ▓▓▓▓▓▓▒▒▒▒▒▒▓▓            ░░                              ");
        System.out.println("                                            ▓▓▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓░░          ░░░░░░░░░░▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓                          ▒▒▒▒▒▒  ");
        System.out.println("                                        ▓▓▒▒▒▒▒▒▒▒▓▓▒▒░░▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░░░  ░░░░░░░░░░░░▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓                    ▒▒▒▒▓▓▒▒▒▒▓▓▒▒");
        System.out.println("                              ░░    ░░▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░░░░░      ░░▒▒▒▒▒▒▓▓▒▒▓▓▒▒▒▒▒▒▓▓▒▒▒▒▓▓▒▒              ░░▒▒▒▒▒▒▒▒▓▓▒▒▒▒▓▓  ");
        System.out.println("                                ░░▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░▒▒▓▓▓▓░░▒▒▓▓▓▓▒▒▓▓▒▒▒▒▒▒▒▒▒▒▓▓          ░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▓▓  ");
        System.out.println("                            ░░░░▓▓▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓██▓▓▓▓▒▒▓▓▒▒░░░░░░░░░░░░░░░░▒▒▓▓▒▒▒▒░░▒▒▓▓▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓      ░░▒▒▒▒▒▒▒▒▒▒▒▒░░      ░░▒▒  ");
        System.out.println("                          ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▒▒▓▓░░░░░░░░░░░░░░▓▓▓▓▓▓▓▓▒▒░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░          ▓▓  ");
        System.out.println("                      ░░░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░░░▓▓▒▒▒▒▒▒▓▓░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░            ▒▒  ");
        System.out.println("                      ░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒██▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓░░            ░░    ");
        System.out.println("                    ░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░░░░░░░░░░░▒▒▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒░░                    ");
        System.out.println("                  ░░▒▒▒▒▒▒░░▒▒▒▒▒▒▓▓▒▒░░▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓████▓▓▓▓████▓▓▓▓▓▓▓▓▓▓░░░░░░▒▒▓▓▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▓▓▒▒░░                      ");
        System.out.println("                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓░░░░░░▒▒▒▒░░▒▒▓▓▓▓▓▓▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒▒▒                          ");
        System.out.println("              ▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░░░▒▒░░▓▓▓▓▓▓▒▒░░░░░░░░▒▒▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▓▓▒▒░░░░░░                      ");
        System.out.println("            ▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓░░░░░░░░▒▒▓▓▓▓░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒░░░░░░░░                      ");
        System.out.println("          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒░░░░░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▒▒░░░░▒▒▓▓  ░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▓▓▒▒░░░░░░  ░░░░                    ");
        System.out.println("        ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒░░░░░░░░░░▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▓▓▒▒░░░░░░▒▒▒▒▒▒▓▓▒▒░░░░░░░░░░░░░░                  ");
        System.out.println("      ░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒░░░░░░░░░░▓▓░░░░░░░░░░░░▓▓░░▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▒▒░░▓▓▓▓▒▒▓▓▓▓░░░░░░▒▒▒▒▒▒▒▒▓▓░░░░░░░░░░    ░░░░                ");
        System.out.println("      ▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▓▓▒▒░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░░░░░▒▒▒▒▒▒▓▓░░░░░░░░░░░░░░░░                  ");
        System.out.println("    ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░    ░░                  ");
        System.out.println("    ▓▓░░▒▒▒▒▒▒▒▒▒▒▒▒▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░                  ");
        System.out.println("    ░░  ░░░░▒▒▒▒▒▒▓▓▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓▓▓▓▓▒▒▒▒░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░░░                        ");
        System.out.println("  ▒▒    ░░▒▒▒▒▒▒▓▓▒▒░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▓▓░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒                                    ");
        System.out.println("        ▒▒▒▒▒▒▒▒▒▒░░  ░░░░░░░░░░░░▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒                                    ");
        System.out.println("        ▒▒▒▒▒▒▒▒        ░░░░░░░░░░▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒                                    ");
        System.out.println("      ░░▒▒▒▒▓▓            ░░░░░░▒▒▒▒▓▓▓▓▓▓▒▒░░░░░░░░░░░░░░░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒░░                                    ");
        System.out.println("      ▒▒▒▒▓▓                ░░░░▒▒▒▒▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▓▓                                      ");
        System.out.println("      ░░▒▒▒▒                  ░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▒▒▒▒▒▒▒▒▓▓░░                                      ");
        System.out.println("    ░░  ▒▒                      ▒▒▓▓▒▒▓▓▒▒▒▒░░░░░░░░░░░░▒▒▒▒▒▒▒▒░░▓▓░░▓▓████▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓░░                                      ");
        System.out.println("      ░░▓▓                      ▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▓▓▒▒▓▓▓▓▒▒▒▒▓▓▓▓░░                                      ");
        System.out.println("      ▒▒▒▒                        ▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓░░                                      ");
        System.out.println("      ▒▒                          ░░▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▓▓▒▒▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓░░▓▓▓▓░░▓▓▓▓  ░░                                    ");
        System.out.println("    ░░▒▒                              ▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒░░▓▓▓▓▒▒▓▓▓▓▒▒░░                                    ");
        System.out.println("      ▓▓                                  ░░▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░▓▓▓▓▓▓▓▓▓▓▒▒▒▒░░▒▒░░                              ");
        System.out.println("      ▓▓                                      ░░░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░  ░░▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒  ░░  ▓▓▓▓▓▓▓▓▓▓░░▒▒░░▒▒▒▒▒▒                            ");
        System.out.println("      ▒▒                                            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓░░        ▒▒    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒      ▒▒▓▓▓▓▓▓▓▓    ░░░░▒▒▒▒▒▒                          ");
        System.out.println("      ░░                                          ░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓            ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░      ▓▓▓▓▓▓▓▓▓▓▒▒          ▒▒░░                        ");
        System.out.println("        ░░                                        ▒▒▓▓██▓▓▓▓▓▓▓▓▓▓▓▓                ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒        ▓▓▓▓▓▓▓▓▓▓                                      ");
        System.out.println("                                                  ▓▓▓▓██▓▓▓▓▓▓▓▓▓▓                    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒        ██▓▓▒▒▒▒▓▓▒▒                                    ");
        System.out.println("                                                ░░▓▓▒▒▓▓▒▒▒▒▓▓▒▒                      ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░        ░░▓▓▒▒▓▓▒▒▓▓                                    ");
        System.out.println("                                                ▒▒▓▓▒▒▓▓▒▒░░            ░░░░░░░░  ░░  ░░▓▓▓▓▓▓▒▒▒▒▓▓▓▓            ▒▒▓▓▒▒▒▒▓▓▒▒                                  ");
        System.out.println("                                                ▒▒▓▓▒▒▓▓▒▒  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░░░░░░░░░░░░    ▓▓▓▓▒▒▓▓                                  ");
        System.out.println("                                              ░░▓▓▓▓▒▒▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░  ░░░░▓▓▓▓▓▓▒▒▓▓░░░░░░░░░░░░░░      ░░▓▓▒▒▒▒▒▒                                ");
        System.out.println("                                            ░░▓▓▓▓▒▒▓▓▓▓▒▒░░    ░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓▒▒▓▓▒▒▒▒░░            ░░▓▓▒▒▓▓▒▒▓▓                              ");
        System.out.println("                                            ▒▒▓▓▒▒▒▒▓▓▓▓▓▓▒▒░░          ░░░░  ░░          ▒▒▓▓▓▓░░▓▓▓▓▒▒▒▒            ░░▓▓▓▓▒▒▓▓▒▒▓▓▒▒                          ");
        System.out.println("                                            ▒▒▒▒  ▓▓▒▒▒▒▒▒▒▒░░                                  ▒▒    ░░                ▒▒▓▓▒▒▒▒▓▓▒▒░░▒▒                        ");
        System.out.println("                                            ░░    ░░▒▒      ░░                                                          ░░  ▒▒▒▒  ░░░░▒▒                        " + ConsoleTextManager.ANSI_RESET);
    }
    

    private void printKnight() {
        System.out.println("      /\\");
        System.out.println("      ||");
        System.out.println("      ||");
        System.out.println("      ||");
        System.out.println("      ||           {}");
        System.out.println("      ||          .--.");
        System.out.println("      ||         /.--.\\");
        System.out.println("      ||         |====|");
        System.out.println("      ||         |`::`|");
        System.out.println("     _||_    .-;`\\..../`;.-.");
        System.out.println("      /\\\\   /  |...::...|  \\");
        System.out.println("      |:'\\ |   /'''::'''\\   |");
        System.out.println("       \\ /\\;-,/\\   ::   /\\--;");
        System.out.println("        \\ <`>  >._::_.<,<__>");
        System.out.println("         `\"\"`  /   ^^   \\|  |");
        System.out.println("               |        |\\::/");
        System.out.println("               |        |/|||");
        System.out.println("               |___/\\___| '''");
        System.out.println("                \\_ || _/");
        System.out.println("                <_ >< _>");
        System.out.println("                |  ||  |");
        System.out.println("                |  ||  |");
        System.out.println("               _\\.:||:./_");
        System.out.println("              /____/\\____\\");
    }
    private void printArcher() {
        System.out.println("                                                      |");
        System.out.println("                                                        \\.");
        System.out.println("                                                        /|.");
        System.out.println("                                                      /  `|.");
        System.out.println("                                                    /     |.");
        System.out.println("                                                  /       |.");
        System.out.println("                                                /         `|.");
        System.out.println("                                              /            |.");
        System.out.println("                                            /              |.");
        System.out.println("                                          /                |.");
        System.out.println("     __                                 /                  `|.");
        System.out.println("      -\\                              /                     |.");
        System.out.println("        \\\\                          /                       |.");
        System.out.println("          \\\\                      /                         |.");
        System.out.println("           \\|                   /                           |\\");
        System.out.println("             \\#####\\          /                             ||");
        System.out.println("         ==###########>     /                               ||");
        System.out.println("          \\##==      \\    /                                 ||");
        System.out.println("     ______ =       =|__/___                                ||");
        System.out.println(" ,--' ,----`-,__ ___/'  --,-`-==============================##==========>");
        System.out.println("\\               '        ##_______ ______   ______,--,____,=##,__");
        System.out.println(" `,    __==    ___,-,__,--'#'  ==='      `-'              | ##,-/");
        System.out.println("   `-,____,---'       \\####\\              |        ____,--\\_##,/");
        System.out.println("       #_              |##   \\  _____,---==,__,---'         ##");
        System.out.println("        #              ]===--==\\                            ||");
        System.out.println("        #,             ]         \\                          ||");
        System.out.println("         #_            |           \\                        ||");
        System.out.println("          ##_       __/'             \\                      ||");
        System.out.println("           ####='     |                \\                    ||");
        System.out.println("            ###       |                  \\                  |.");
        System.out.println("            ##       _'                    \\                |.");
        System.out.println("           ###=======]                       \\              |.");
        System.out.println("          ///        |                         \\           ,|.");
        System.out.println("          //         |                           \\         |.");
        System.out.println("                                                   \\      ,|.");
        System.out.println("                                                     \\    |.");
        System.out.println("                                                       \\  |.");
        System.out.println("                                                         \\|.");
        System.out.println("                                                         /.");
        System.out.println("                                                        |.");
    }
    private void printPaladin() {
        System.out.println("                            _____");
        System.out.println("             ,             /@@@@@=-");
        System.out.println("             \\            @@@@@@@@@@=-");
        System.out.println("             \\          _\\@/\\@@@@@=-");
        System.out.println("             \\        /_ +\\ \\@@@@@=-");
        System.out.println("        ,      \\      (_/   )  \\@@@@=-");
        System.out.println("        \\      \\     (_____)    \\@@=-");
        System.out.println("        _\\_ /\\_ _\\__  /     \\     ~~");
        System.out.println("  ____,/+-  `/\\  { \\_|___(__ )");
        System.out.println(" >             \\  )_|/  ___  \\");
        System.out.println(" \\_/--\\___/     \\.` / <-q-p-> \\");
        System.out.println("    _//   )      \\(\\/\\ <-d-b-> /___");
        System.out.println(" _____  /         \\/ \\  \\|/  //   \\__");
        System.out.println(" /     \\/          /   \\_____//     \\_\\");
        System.out.println(" | /\\_  |         (_  /______\\\\     |||");
        System.out.println(" | \\_ | |         | \\|   <    \\\\    /||");
        System.out.println(" \\_\\_\\ \\/     ____\\  |____\\    \\)  / ||");
        System.out.println("       /    _/  <____)\\    (      / //\\\\");
        System.out.println("      /   _/           \\    \\    (  \\\\//");
        System.out.println("     (   /              )  / \\    \\  \\/");
        System.out.println("     /  /              /  /   \\    )");
        System.out.println(" ---/  /-------------/  /------)  /-----");
        System.out.println("  _/__/           _/__/     /  /");
        System.out.println(" /__/           /__/     _/__/");
        System.out.println("                         /__/");
    }
    private void printWizard() {
        System.out.println("                    ____ ");
        System.out.println("                  .'* *.'");
        System.out.println("               __/_*_*(_");
        System.out.println("              / _______ \\");
        System.out.println("             _\\_)/___\\(_/_ ");
        System.out.println("            / _((\\- -/))_ \\");
        System.out.println("            \\ \\())(-)(()/ /");
        System.out.println("             ' \\(((()))/ '");
        System.out.println("            / ' \\)).))/ ' \\");
        System.out.println("           / _ \\ - | - /_  \\");
        System.out.println("          (   ( .;''';. .'  )");
        System.out.println("          _\\\"__ /    )\\ __\"/_");
        System.out.println("            \\/  \\   ' /  \\/");
        System.out.println("             .'  '...' ' )");
        System.out.println("              / /  |  \\ \\");
        System.out.println("             / .   .   . \\");
        System.out.println("            /   .     .   \\");
        System.out.println("           /   /   |   \\   \\");
        System.out.println("         .'   /    b    '.  '.");
        System.out.println("     _.-'    /     Bb     '-. '-._");
        System.out.println(" _.-'       |      BBb       '-.  '-.");
        System.out.println("(________mrf\\____.dBBBb.________)____)");
    }
    private void printBerserk(){
        //! PLACEHOLDER
        System.out.println("                                           _.gd8888888bp._");
        System.out.println("                                        .g88888888888888888p.");
        System.out.println("                                      .d8888P\"\"       \"\"Y8888b.");
        System.out.println("                                      \"Y8P\"               \"Y8P'");
        System.out.println("                                         `.               ,'");
        System.out.println("                                           \\     .-.     /");
        System.out.println("                                            \\   (___)   /");
        System.out.println(" .------------------._______________________:__________j");
        System.out.println("/                   |                      |           |`-.,_");
        System.out.println("\\###################|######################|###########|,-'`");
        System.out.println(" `------------------'                       :    ___   l");
        System.out.println("                                            /   (   )   \\");
        System.out.println("                                           /     `-'     \\");
        System.out.println("                                         ,'               `.");
        System.out.println("                                      .d8b.               .d8b.");
        System.out.println("                                      \"Y8888p..       ,.d8888P\"");
        System.out.println("                                        \"Y88888888888888888P\"");
        System.out.println("                                           \"\"YY8888888PP\"");
    }

}