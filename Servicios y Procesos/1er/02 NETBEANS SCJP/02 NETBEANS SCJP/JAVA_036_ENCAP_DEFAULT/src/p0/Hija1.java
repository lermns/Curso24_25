// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// "de paquete" - "por defecto" - "amistoso" - "package" - "default" - "friendly".


package p0;

public class Hija1 extends Madre {

    public static void main(String[] args) {
        
        Madre madre = new Madre();
        
        System.out.println("HIJA1 --> DINERO DE MADRE = " + madre.dinero);
    }
}