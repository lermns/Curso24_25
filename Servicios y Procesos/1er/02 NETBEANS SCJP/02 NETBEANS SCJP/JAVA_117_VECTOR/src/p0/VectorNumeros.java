// Comprobar el funcionamiento de la clase de colección Vector, que conjuntamente
// con Hashtable, son las 2 únicas colecciones sincronizadas "de fábrica" (a ambas
// se las consideran desfasadas). Hacer uso de un Iterator y de un Enumeration a la
// hora de trabajar con los elementos de la colección (se aconseja el uso de Iterator
// sobre Enumeration ... también está desfasada).


package p0;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector; // colección obsoleta (muy antigua, desfasada.

public class VectorNumeros {

    public static void main(String[] args) {
        
        Vector<Integer> vector = new Vector<Integer>();
        
        vector.add(8);
        vector.add(4);
        vector.insertElementAt(5, 1); // insertar, efecto cuña.
        
        System.out.println(vector);
        
        System.out.println("\n__________________\n");
        
        Iterator<Integer> it = vector.iterator(); // obtener iterador.

        while(it.hasNext()) { // es de 1 sólo uso, no se puede reutilizar.
            int valor = it.next();
            System.out.println("---> " + valor);
        }

        System.out.println("\n....................\n");        
        
        // HAY QUE RECARGAR EL ITERADOR:
        it = vector.iterator(); // recarga = volver a llamar al método iterator();
       
        while(it.hasNext()) {
            int valor = it.next();
            System.out.println("---> " + valor);
        }

        System.out.println("\n__________________\n");
        
        Enumeration<Integer> e = vector.elements(); // obtener Enumerador (desfasado).

        while(e.hasMoreElements()) {
            int valor = e.nextElement();
            System.out.println("---> " + valor);
        }               
    }    

}