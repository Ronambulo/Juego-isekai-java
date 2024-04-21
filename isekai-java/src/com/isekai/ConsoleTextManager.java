package com.isekai;

public class ConsoleTextManager {

    private Texto numberToText;
    private Entity entityAttack;
    private Entity entityDefend;

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
                System.out.println("Hola");
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
}
