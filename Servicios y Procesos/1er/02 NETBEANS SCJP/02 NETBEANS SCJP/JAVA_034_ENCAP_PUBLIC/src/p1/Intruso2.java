// Crear una clase que NO herede de la clase Madre y comprobar cómo puede acceder al
// atributo públic definido en ella (NO estamos en el mismo paquete que la madre p0).

// Se requiere la importación de la clase madre al paquete actúal.


package p1;

import p0.Madre;

public class Intruso2 {

    public static void main(String[] args) {
        
        Madre madre = new Madre();
        System.out.println("INTRUSO2 -> DINERO DE MADRE ... " + madre.dinero);
    }    
}