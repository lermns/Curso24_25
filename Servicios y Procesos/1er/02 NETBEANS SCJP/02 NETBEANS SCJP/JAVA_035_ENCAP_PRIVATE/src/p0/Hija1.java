// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// private.


package p0;

public class Hija1 extends Madre {

    public static void main(String[] args) {
        
        Madre madre = new Madre();
        
        // ERROR
        //System.out.println("HIJA1 --> DINERO DE MADRE = " + madre.dinero);
    }   
}