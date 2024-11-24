// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// private.


package p0;

public class Madre {
    
    //PRIVATE - ACCESO SÓLO POR LOS MIEMBROS DE LA PROPIA CLASE Y NADIE MÁS (SEAS O NO HIJA)
    
    private int dinero = 2000;
    
    public static void main(String[] args) {
        Madre madre = new Madre();
        System.out.println("MADRE --> DINERO DE MADRE = " + madre.dinero);
    }
}



class Hija0 {
    public static void main(String[] args) {
        
        // Error. Estamos en el mismo fichero, mismo paquete, pero son clases distintas.
        //System.out.println("HIJA0 --> DINERO MADRE = " + new Madre().dinero);        
    }
}