// Crear una clase Madre que defina un método comer(), el cuál imprimirá por 
// pantalla "COME VERDURA". Dicho método se declarará final, de forma que las
// subclases hijas no puedan sobrescribirlo.


package p2;

public class MadreMetodoFinal {

    public final void comer() {
        System.out.println("COME VERDURA");
    }    
}