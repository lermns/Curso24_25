// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// private.


package p1;

import p0.Madre;

public class Hija2 extends Madre {

    public static void main(String[] args) {
        
        Madre madre = new Madre();
        
        // ERROR
        //System.out.println("HIJA2 --> DINERO DE MADRE = " + madre.dinero);   
    }   
}