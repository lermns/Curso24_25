// Crear la clase Hija como heredera de la clase Madre. Hacemos a Hija final, de forma
// que constituye el final de está linea de jerarquía (ya no se podrá extender/heredar
// a la misma).


package p0;

public final class Hija extends Madre {

    public Hija() { 
        System.out.println("CONSTRUCTOR DE LA HIJA");
    }    
}