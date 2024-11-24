// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// protected.


package p0;

public class Hija1 extends Madre {

    public static void main(String[] args) {
        
        Madre madre = new Madre(); // instancia de la madre.
        
        // Se entra por "default" y no por protected tal y como podriamos pensar.
        System.out.println("HIJA1 --> DINERO DE MADRE = " + madre.dinero);
        
        Hija1 hija1 = new Hija1(); // instancia de la hija (tiene su atributo heredado).
        
        System.out.println("HIJA1 --> DINERO DE MADRE = " + hija1.dinero);
    }    
}