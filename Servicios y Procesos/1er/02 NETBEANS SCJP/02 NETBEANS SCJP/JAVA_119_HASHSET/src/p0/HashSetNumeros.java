// Crear la clase HashSetNumeros, para comprobar cómo un conjunto NO admite
// elementos repetidos. Para ello, ir añadiendo distintos números y comprobar
// el valor booleano devuelto por el método add (true si lo añadió, false si
// no lo añadió).

// Nota: las colecciones que empiezan por Hash utilizan técnica de Hashing la
// cuál consiste en invocar el método hashCode del elemento y comprobar si el
// número devuelto se corresponde con alguno de los ya existentes, añadiendo
// o no en consecuencia dicho elemento a la colección.

// Nota: Es más sencillo comparar números enteros que tener que invocar al
// equals y ejecutar toda su funcionalidad para determinar si dicho elemento
// está ya o no en la colección (se habla por tanto de comparación rápida o
// en superficie LIGH-COMPARATION, en lugar de realizar una comparación en 
// profundidad DEEP-COMPARATION).

// Para recorrer los elementos del Set obtener su Iterator, ya que al no haber
// índice no podemos recorrerlos por la posición que ocupan (es cómo si estuviesen
// dentro de una bolsa de plástico, en lugar de ordenados, por ejemplo lo estarían,
// en una caja de coleccionista de minerales.

package p0;

import java.util.HashSet;
import java.util.Iterator;


public class HashSetNumeros {

    public static void main(String[] args) {
        
        HashSet conjuntoNumeros = new HashSet();
        
        boolean añadido;
        
        // El código hash de un wrapper Integer equivale a su valor int.
        // Si solo ponemos un int no va a tener disponible el método para poder comparar
        Integer n1 = new Integer(8);
        //Podríamos haber puesto:
        //Integer n1 = 8;
        //NO podríamos haber puesto:
        //int n1 = new Integer(8);
        //int n1=8;
        
        
        
        
        
        // No podemos modificar Integer para sobrescribir el método hashCode y
        // poder visualizar cuándo y cómo se llama.
        
        añadido = conjuntoNumeros.add(n1); // devuelve true si lo añadió
        System.out.println("HASCODE DE n1 ... " + n1.hashCode());
        System.out.println("SE AÑADIO EL 8 ... " + añadido + "\n");
        
        Integer n2 = new Integer(7);
        añadido = conjuntoNumeros.add(n2);
        System.out.println("HASCODE DE n2 ... " + n2.hashCode());        
        System.out.println("SE AÑADIO EL 7 ... " + añadido + "\n");
        
        Integer n3 = new Integer(7); // no se añade, ya que el hashCode es 7
        añadido = conjuntoNumeros.add(n3);
        System.out.println("HASCODE DE n3 ... " + n3.hashCode());        
        System.out.println("SE AÑADIO EL 7 ... " + añadido + "\n");
        
        System.out.println("NUMEROS ... " + conjuntoNumeros);
        
        
        /////////////// RECUPERAR ELEMENTOS - NO HAY ÍNDICE /////////////
        
        System.out.println("\n________________________________\n");
        
        Iterator it = conjuntoNumeros.iterator();
        
        while(it.hasNext()) {
            System.out.println("---> " + it.next());
        }
        
        System.out.println("\n ... QUE CODIGO DE HASH TENEMOS PARA UN FLOAT ... \n");
        Float f = 1.3F;
        System.out.println("hashCode de 1.3F  ---> " + f.hashCode()); // 1067869798
    }

}