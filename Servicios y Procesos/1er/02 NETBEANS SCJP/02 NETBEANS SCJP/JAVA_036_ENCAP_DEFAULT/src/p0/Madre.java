// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// "de paquete" - "por defecto" - "amistoso" - "package" - "default" - "friendly".


package p0;

public class Madre {

    // TODAS LAS CLASES QUE PERTENEZCAN AL PAQUETE p0, SEAN O NO HIJAS, Y NINGUNA MÁS.
    int dinero = 3000;
    
    public static void main(String[] args) {
        Madre madre = new Madre();
        System.out.println("MADRE --> DINERO MADRE " + madre.dinero);
    }    
}