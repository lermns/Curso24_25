// Crear la clase Supermercado para instanciar distintos tipos de artículos.
// Introducir todos y cada uno de ellos en una colección TreeSet, para a 
// continuación mostrarlos por pantalla, bien a través de invocar al método
// toString, o mediante el iterador (interfaz Iterator) recuperado de la propia
// colección. Observar como se sigue la ordenación natural definida en la clase
// abstracta Articulo (ascendente por precio).


package articulos;

import java.util.Iterator;
import java.util.TreeSet;


public class Supermercado {

    public static void main(String[] args) {
        
        Articulo a1 = new Bici();
        Articulo a2 = new Pan();
        Articulo a3 = new PC();
        
        TreeSet<Articulo> losArticulos = new TreeSet<Articulo>();
        
        losArticulos.add(a3);
        losArticulos.add(a2);
        losArticulos.add(a1);
        
        System.out.println("MOSTRAR USANDO toString: \n\n" + losArticulos);
        
        System.out.println("\n__________________________________________\n");

        System.out.println("MOSTRAR USANDO Iterator: \n");
        
        Iterator it = losArticulos.iterator(); // obtener el iterador del TreeSet.
        
        while(it.hasNext()) {
            System.out.println("---> " + it.next());
        }
    }    

}