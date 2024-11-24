// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// "de paquete" - "por defecto" - "amistoso" - "package" - "default" - "friendly".


package p0;

public class Intruso1 {

    public static void main(String[] args) {
        
        Madre madre = new Madre();
              
        System.out.println("INTRUSO1 --> DINERO DE MADRE " + madre.dinero);        
    }    
}