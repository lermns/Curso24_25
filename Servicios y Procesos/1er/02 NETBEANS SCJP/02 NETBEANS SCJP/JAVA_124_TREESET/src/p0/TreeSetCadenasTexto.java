// Crear una clase que ponga de manifiesto el funcionamiento de un árbol de
// ordenación natural, en este caso un TreeSet (implementa la interfaz SortedSet),
// para comprobar cómo el sistema "coloca" internamente los elementos de la 
// colección en orden natural ascendente (es así por defecto, salvo que usemos un 
// Comparator). Ésto, hace que sea imprescindible, que tales elementos puedan ser
// comparados entre sí, es decir, que tienen la obligatoriedad de implementar la
// interfaz java.lang.Comparable y definir su método compareTo(Object), el cuál,
// podríamos marcar con <género> para simplicar el código final.


package p0;

import java.util.TreeSet;


public class TreeSetCadenasTexto {

    public static void main(String[] args) {
        
        TreeSet<String> cadenas = new TreeSet<String>();
        
        cadenas.add("A");
        cadenas.add("z");
        cadenas.add("Z");
        cadenas.add("a");
        cadenas.add("9");
        cadenas.add(" ");
        cadenas.add("-1");
        cadenas.add("3");
        cadenas.add("3");
        cadenas.add("3"); // espacios -> negativos asc -> positivos asc -> letras asc.
        
        System.out.println(cadenas); // se imprimen en orden natural ascendente.
        
        cadenas.clear(); // vaciar la colección.   
        
        cadenas.add("LUCIA");
        cadenas.add("LIANA");
        cadenas.add("LEILA");
        cadenas.add("LIDIA");
        cadenas.add("LAURA");
        cadenas.add("LEONOR");
        
        System.out.println(cadenas);
        
        cadenas.clear();
                
        TreeSet elementos = new TreeSet();
        
        elementos.add(5); // autoboxing        
        elementos.add(Integer.valueOf("6")); // wrapper directo.
        //elementos.add("6");
        
        System.out.println(elementos);   
    }

}