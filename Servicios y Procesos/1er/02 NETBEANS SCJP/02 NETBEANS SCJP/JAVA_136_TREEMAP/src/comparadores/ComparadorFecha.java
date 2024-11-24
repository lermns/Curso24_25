// Crear un comparador de fecha (año) a utilizar sobre la clase Coche.


package comparadores;

import coches.Coche;
import java.util.Comparator;


public class ComparadorFecha implements Comparator<Coche> {

    @Override
    public int compare(Coche coche1, Coche coche2) {

        Integer fechaCoche1 = new Integer(coche1.getFecha());
        Integer fechaCoche2 = new Integer(coche2.getFecha());
        
        // ORDEN ASCENDENTE ... se comparan una pareja de números enteros.
        return fechaCoche1.compareTo(fechaCoche2);        
    }
    
}