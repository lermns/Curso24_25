// Crear la clase ComparadorMedida para realizar la ordenación de los 
// pasteles en función del tamaño de los mismos. Marcar la interfaz
// Comparator con el género <Pastel> para que el método compare se
// muestre por pantalla con parámetros Pastel, en lugar de Object.


package comparadores;

import java.util.Comparator;
import pasteleria.Pastel;


public class ComparadorMedida implements Comparator<Pastel> {

    public ComparadorMedida() {
        System.out.println("COLOCAR LOS PASTELES POR MEDIDA ASCENDENTE: \n");
    }    
    
    // Usamos compareTo dentro de compare para devolver el valor de ordenación.    
    @Override
    public int compare(Pastel p1, Pastel p2) {
        // Utilizamos la implementación compareTo del tipo enumerado.
        return p1.getMedida().compareTo(p2.getMedida());
    }

}