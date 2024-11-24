// Crear un comparador de precio a utilizar sobre la clase Coche. Se dispone
// de un atributo privado y booleado llamado "ordenInverso" que de estar
// a true, establecerá el orden de mayor a menor, en lugar del natural que
// sería de menor a mayor. Su valor se determina en el constructor de la clase.


package comparadores;

import coches.Coche;
import java.util.Comparator;


public class ComparadorPrecio implements Comparator<Coche> {

    private boolean ordenInverso; // de más caro a más barato (mayor->menor).

    // A través del constructor del comparador y solicitando un paràmetro de entrada
    // para éste, podemos establer el orden, directo o inverso, de la comparación.
    public ComparadorPrecio(boolean ordenInverso) {
        this.ordenInverso = ordenInverso; // determinar al instanciar el comparador.
    }
    
    @Override
    public int compare(Coche coche1, Coche coche2) {

        // utilizamos en este caso los métodos compareTo de la clase
        // Integer. También podríamos realizar la diferencia directa,
        // algo mucho más sencillo y rápido que el uso de los Integer.        
        Integer precioCoche1 = new Integer(coche1.getPrecio());
        Integer precioCoche2 = new Integer(coche2.getPrecio());
    
        if(ordenInverso) {
            // B con A.
            return precioCoche2.compareTo(precioCoche1);        
        } else {
            // A con B.
            return precioCoche1.compareTo(precioCoche2);                
        }
    }

}