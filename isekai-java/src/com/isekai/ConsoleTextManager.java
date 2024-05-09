package com.isekai;
import java.util.concurrent.*;
import com.isekai.entities.*;

public class ConsoleTextManager {

    //COLORES ANSI (unicode)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BROWN = "\u001B[33m";
    public static final String ANSI_GREY = "\u001B[37m";

    private Texto numberToText;
    private Entity entityAttack;
    private Entity entityDefend;
    private static ConsoleTextManager instance;

    

    private ConsoleTextManager(){
        super();
    }

    public static ConsoleTextManager getInstance(){
        if(instance == null){
            instance = new ConsoleTextManager();
        }
        return instance;
    }

    public void writeText( Texto dialogo){
        this.numberToText = dialogo;
        numberToText();
    }

    public void writeText(Entity entityAttack, Texto dialogo){
        this.numberToText = dialogo;
        this.entityAttack = entityAttack;
        numberToText();
    }

    public void writeText(Entity entityAttack, Entity entityDefend, Texto dialogo){
        this.numberToText = dialogo;
        this.entityAttack = entityAttack;
        this.entityDefend = entityDefend;
        numberToText();
    }

    private void numberToText(){
        switch (this.numberToText.getNumber()) {
            case 1: //introduccion
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
                System.out.println("██╗  ██╗ █████╗ ███████╗     ██████╗  █████╗ ███╗   ██╗ █████╗ ██████╗  ██████╗ ");
                System.out.println("██║  ██║██╔══██╗██╔════╝    ██╔════╝ ██╔══██╗████╗  ██║██╔══██╗██╔══██╗██╔═══██╗");
                System.out.println("███████║███████║███████╗    ██║  ███╗███████║██╔██╗ ██║███████║██║  ██║██║   ██║");
                System.out.println("██╔══██║██╔══██║╚════██║    ██║   ██║██╔══██║██║╚██╗██║██╔══██║██║  ██║██║   ██║");
                System.out.println("██║  ██║██║  ██║███████║    ╚██████╔╝██║  ██║██║ ╚████║██║  ██║██████╔╝╚██████╔╝");
                System.out.println("╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═════╝ ╚═════╝ ");                
                break;
            case 7: //Derrota
                System.out.println(" ██╗  ██╗ █████╗ ███████╗    ███╗   ███╗██╗   ██╗███████╗██████╗ ████████╗ ██████╗ ");
                System.out.println(" ██║  ██║██╔══██╗██╔════╝    ████╗ ████║██║   ██║██╔════╝██╔══██╗╚══██╔══╝██╔═══██╗");
                System.out.println(" ███████║███████║███████╗    ██╔████╔██║██║   ██║█████╗  ██████╔╝   ██║   ██║   ██║");
                System.out.println(" ██╔══██║██╔══██║╚════██║    ██║╚██╔╝██║██║   ██║██╔══╝  ██╔══██╗   ██║   ██║   ██║");
                System.out.println(" ██║  ██║██║  ██║███████║    ██║ ╚═╝ ██║╚██████╔╝███████╗██║  ██║   ██║   ╚██████╔╝");
                System.out.println(" ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝    ╚═╝     ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝ ");
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

    public void playerInfo(Entity player, String playerName){
        System.out.println("| " + playerName + "\t\tPoder: " + player.getPower() + " Vida: " + player.getLives() + " \t|");
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
                // printSlime();
                break;
            default:
                break;
        }
    }

    public void printWolf() {
        System.out.println(ConsoleTextManager.ANSI_GREY +"       / \\      _-'");
        System.out.println("     _/|  \\-''- _ /");
        System.out.println("__-' { |          \\");
        System.out.println("    /             \\");
        System.out.println("    /       \"o.  |o }");
        System.out.println("    |            \\ ;");
        System.out.println("                  ',");
        System.out.println("       \\_         __\\");
        System.out.println("         ''-_    \\.//");
        System.out.println("           / '-____'");
        System.out.println("          /");
        System.out.println("        _'");
        System.out.println("      _-'" + ConsoleTextManager.ANSI_RESET);
    }

    public void printOgre() {
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
    
    public void printBee() {
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
    
    public void printGoat() {
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
    
    //!FALTA SLIME
    public void printSlime() {
        System.out.println("          ██████████          ");
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
        System.out.println("    ██████████████████████    ");
    }
    
    

    public void printKnight() {
        System.out.println("    /\\");
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
    
    public void printArcher() {
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
    
    public void printPaladin() {
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
    
    public void printWizard() {
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
    
}
