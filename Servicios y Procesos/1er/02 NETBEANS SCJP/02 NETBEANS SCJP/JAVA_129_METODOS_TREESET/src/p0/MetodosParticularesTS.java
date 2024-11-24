// Crear una clase MetodosTreeSet que ponga de manifiesto los métodos
// particulares de la colección TreeSet, como son ceiling, higher, floor,
// first, last, heatSet y tailSet.


package p0;

import java.util.Iterator;
import java.util.TreeSet;


public class MetodosParticularesTS {

    public static void main(String[] args) {
        
        TreeSet<String> letras = new TreeSet<String>();
        
        // ORDENACIÓN NATURAL. Los String implementan Comparable.
        
        letras.add("a");
        
        letras.add("c");
        
        letras.add("e");
        
        letras.add("f");
        
        System.out.println(letras); // se ordenan solos a,c,e,f.
        
        System.out.println("\n_______________________________\n");        
        
        Iterator it = letras.iterator();
        
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\n_______________________________\n");
        
        Iterator itd = letras.descendingIterator(); // en orden inverso f,e,c,a.
        
        while(itd.hasNext()) {
            System.out.print(itd.next() + " ");
        }
        
        
        System.out.println("\n___________ ceiling de c ___________\n");
        // el elemento si existe o el más cercano por exceso (como higher).
        // a,c,e,f.
        System.out.println(letras.ceiling("c")); // c

        System.out.println("\n___________ ceiling de b ___________\n");
        System.out.println(letras.ceiling("b")); // c
    
        
        
        System.out.println("\n___________ first ___________\n");
        // el primero de la colección.
        // a,c,e,f.
        System.out.println(letras.first()); // a

        
        
        System.out.println("\n___________ last ___________\n");
        // el último de la colección.
        // a,c,e,f.
        System.out.println(letras.last()); // f
        
        
        
        System.out.println("\n___________ floor de b ___________\n");
        // el elemento si existe o el más cercano por defecto.
        // a,c,e,f.
        System.out.println(letras.floor("b")); // a
       
        System.out.println("\n___________ floor de d ___________\n");
        System.out.println(letras.floor("d")); // c

        
        
        System.out.println("\n___________ higher de d ___________\n");
        // el elemento si existe o el más cercano por exceso (como ceiling).
        // a,c,e,f.
        System.out.println(letras.higher("d")); // e
        
        System.out.println("\n___________ higher de g ___________\n");
        // nos dará null, ya que la última letra es f (g está por delante).
        System.out.println(letras.higher("g")); // null
        
        
        
        System.out.println("\n______________ headSet de c ______________\n");
                
        Iterator itIzquierda = letras.headSet("c").iterator();
        // elementos desde el inicio hasta el indicado (sin incluirlo).
        // a,c,e,f.
        while(itIzquierda.hasNext()) {
            System.out.print(itIzquierda.next() + " "); // a
        }

        
        
        System.out.println("\n______________ tailSet de c ______________\n");
        
        Iterator itDerecha   = letras.tailSet("c").iterator();
        // elementos desde el indicado (incluído) hasta el final.
        // a,c,e,f.
        while(itDerecha.hasNext()) {
            System.out.print(itDerecha.next() + " "); // c e f
        }
        
        System.out.println("\n");
    }   

}