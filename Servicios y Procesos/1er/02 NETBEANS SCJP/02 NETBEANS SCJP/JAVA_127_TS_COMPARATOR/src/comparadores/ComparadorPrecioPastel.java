// Crear la clase ComparadorPrecioPastel para realizar la ordenación de los 
// pasteles en función del precio de los mismos.


package comparadores;

import java.util.Comparator;
import pasteleria.Pastel;


public class ComparadorPrecioPastel implements Comparator<Pastel> {

    public ComparadorPrecioPastel() {
        System.out.println("COLOCAR LOS PASTELES POR PRECIO ASCENDENTE: \n");
    }
    
    @Override
    public int compare(Pastel p1, Pastel p2) {
        // son números enteros, luego podemos realizar una resta directamente,
        // o convertir a Integer y hacer uso de su método compareTo:        
        
        //return ((Integer)p1.getPrecio()).compareTo((Integer)p2.getPrecio());
        
        return p1.getPrecio() - p2.getPrecio();
    }

}