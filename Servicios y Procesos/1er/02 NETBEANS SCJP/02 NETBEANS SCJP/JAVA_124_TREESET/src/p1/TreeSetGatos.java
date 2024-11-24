// Crear una clase que instance distintos objetos de tipo Gato y los introduzca
// en un TreeSet. Imprimir el contenido de éste y observar cómo dichos elementos
// se visualizan en orden natural (ascendente o descendente según el código 
// implementado en el método compareTo de la clase Gato). Opcionalmente, utilizar
// la marca de género <Gato> para la colección.


package p1;

import java.util.TreeSet;


public class TreeSetGatos {

    public static void main(String[] args) {
        
        Gato g1 = new Gato("FELIX", 2);
        Gato g2 = new Gato("ISIDORO", 3);
        Gato g3 = new Gato("GARFIELD", 1);
        Gato g4 = new Gato("ISIDORO", 4);

        // El uso de un TreeSet o un TreeMap requiere ordenación sobre los elementos, ya sea
        // de tipo natural (sus elementos son Comparable) o bien personalizada (usando un
        // comparador, clase que implementa la interfaz Comparator).
        
        // Comparable ... método compareTo(X).
        // Comparator ... método compare(X,Y).
        TreeSet<Gato> losGatos = new TreeSet<Gato>();
        
        losGatos.add(g1); // el TreeSet es sorted, lo que implica ordered.
        losGatos.add(g2);
        losGatos.add(g3);
        losGatos.add(g4);
        
        System.out.println(losGatos); // los elementos salen ordenamos automáticamente.
    }

}