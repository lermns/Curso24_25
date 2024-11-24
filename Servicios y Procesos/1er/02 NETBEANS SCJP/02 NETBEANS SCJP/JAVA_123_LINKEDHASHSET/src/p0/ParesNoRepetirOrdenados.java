// Crear una clase que utilice la colección LinkedHashSet para almacenar un
// total de 10 números pares entre el 1 y el 100 (dado que es un conjunto,
// no se admitirán repetidos). Convertir el conjunto (Set) en una lista (List)
// a través de los distintos constructores de los que disponen las clases
// LinkedHashSet y LinkedList (ambos piden como argumento de entrada un Collection).
// Utilizar la clase de utilidad Collections (no confundir con Collection), para
// que a través de su método sort(ordenar), que pide un List (en este caso usaremos
// el LinkedList obtenido del LinkedHashSet), provoque la ordenación ascendente de
// los elementos contenidos en él. Finalizado el proceso, volver a convertir la
// lista en el conjunto original LinkedHashSet e imprimir su contenido.

// Nota: HashSet no es ordered, LinkedHashSet sí lo es, de ahí que podamos
// ver la ubicación de los elementos según se fueron introduciendo.


package p0;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class ParesNoRepetirOrdenados {

    public static void main(String[] args) {
        
        // Utilizamos un LinkedHashSet (no admite duplicados pero no tiene método
        // de ordenación de los elementos).
        LinkedHashSet numerosPares = new LinkedHashSet();
        
        for (int i = 0; i < 10; ) { // añadir 10 pares no repetidos entre [1..100].
                                    // No ponemos el incremento ya que solo lo haremos si ha metido un par
            
            int aleatorio = (int)(Math.random()*100 + 1); // [1..100]
            
            if(numerosPares.contains(aleatorio) || aleatorio%2 != 0) {
                continue;
            }
            
            numerosPares.add(aleatorio);
            i++; // aquí es donde estamos haciendo el incremento, para poder realizar el continue sin incrementar
        }
        
        System.out.println("LinkedHashSet (NO ordenados) ---> " + numerosPares);
        
        // *** PASAR DE SET A LIST USANDO LOS CONSTRUCTORES ***
        // El constructor sobrecargado de los linkedList admite un Collection y dado
        // que tanto Set como List lo son, podemos facilmente convertir uno en otro.
        LinkedList listado = new LinkedList(numerosPares);
        
        // La clase de utilidad Collections, en su método sort, pide un List.
        Collections.sort(listado); // NO ADMITE SET.
        
        System.out.println("\n" + "LinkedList (ordenados ASC) ---> " + listado + "\n");
        
        // *** PASAR DE LIST A SET USANDO LOS CONSTRUCTORES ***
        // El constructor sobrecargado de los linkedHashSet admite un Collection.        
        numerosPares = new LinkedHashSet(listado);
        
        
        // Gracias al índice interno (no disponible para el programador) de los LinkedList
        // podemos garantizar que el orden con el que se muestran los elementos será el
        // mismo que el utilizado para añadir los elementos inicialmente.
        System.out.println("LinkedHashSet (ordenados ASC) ---> " + numerosPares + "\n");        
    }   
}