package com.isekai;
import java.util.concurrent.*;
import com.isekai.entities.*;

public class ConsoleTextManager {

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
                System.out.println("\n\nBienvenido a Isekai, el juego de rol por consola, donde tu eres el protagonista y debes enfrentarte a los monstruos de este mundo para poder volver al tuyo.");
                waitSeconds(1);
                System.out.println("Ibas caminando por la calle cuando de repente te desmayaste y al despertar te encontrabas en un lugar desconocido.\n");
                waitSeconds(1);
                System.out.println("Un anciano te explica que estas en un mundo paralelo y que para volver al tuyo debes derrotar a los monstruos que habitan en este mundo.");
                waitSeconds(1);
                System.out.println("El anciano te da a elegir entre 5 clases, cada uno con sus propias armas, elige sabiamente.");
                waitSeconds(2);
                break;
            case 2: //Ataque
                System.out.println(this.entityAttack.getName() + " ataca a " + this.entityDefend.getName() + " con " + this.entityAttack.getPower() + " de daño");
                break;

            case 3: //Curacion
                System.out.println(this.entityAttack.getName() + " se cura");
                break;

            case 4: //Defensa
                System.out.println(this.entityAttack.getName() + " se defiende");
                break;
            case 5: //Muerte
                System.out.println(this.entityAttack.getName() + " ha muerto");
                break;
            case 6: //Victoria
                System.out.println("Has ganado");
                break;
            case 7: //Derrota
                System.out.println("Has perdido");
                break;
            default:
                break;
        }
    }

    public void waitSeconds(Integer seconds) {
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch(InterruptedException e){
                e.printStackTrace();
        } 
    }

    public void playerInfo(Entity player){
        System.out.println();
        System.out.println(player.toString() + "Power: " + player.getPower() + " Lives: " + player.getLives());
        System.out.println();
    }
}
