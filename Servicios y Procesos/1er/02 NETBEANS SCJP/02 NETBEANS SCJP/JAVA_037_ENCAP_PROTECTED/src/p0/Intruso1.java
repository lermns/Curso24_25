// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// protected.


package p0;

public class Intruso1 {

    public static void main(String[] args) {
        
        Madre madre = new Madre();
     
        // Entra por "default", ya que está en el mismo paquete que la madre.
        System.out.println("INTRUSO1 --> DINERO DE MADRE " + madre.dinero);        
    }    
}
