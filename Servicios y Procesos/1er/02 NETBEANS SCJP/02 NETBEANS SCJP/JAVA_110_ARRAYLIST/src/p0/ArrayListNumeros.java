// Crear una clase que ponga d manifiesto los principales métodos de uso en
// una colección ArrayList. Añadir, reemplazar, buscar, imprimir ... los 
// distintos elementos de la colección.

// Nota: Recordar que miemtras que no marquemos la colección con género, el
// contenido de la misma podrá ser heterogéneo (cualquier tipo) y que los 
// elementos entran y salen de la misma vistos como Object.


package p0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class ArrayListNumeros {

    public static void main(String[] args) {
        
        ArrayList numeros = new ArrayList();
        
        numeros.add(5); // posición 0 y autoboxing a Integer
        numeros.add(9); // posición 1
        numeros.add(6); // posición 2 ... añade siempre al final.
        
        System.out.println(numeros);
        
        System.out.println("\n___________________\n");
        
        numeros.add(3,8); // (posicion, elemento)
        System.out.println(numeros);
        
        System.out.println("\n___________________\n");
        
        numeros.add(3,7); // No machaca el existente, siño que hace efecto cuña,
        System.out.println(numeros); // desplazando el resto hacia arriba.

        System.out.println("\n___________________\n");        
        
        //numeros.add(10,10); // NO DEJAR HUECOS ... IndexOutOfBoundsException. 
        
        numeros.add(null); // correcto, y el elemento aparece como null (NO ES HUECO)
        numeros.add(10);        
        System.out.println(numeros);
        
        System.out.println("\n___________________\n");        
        
        ArrayList lote = new ArrayList();
        lote.add(-1);
        lote.add(-2);
        lote.add(-3);
        
        numeros.addAll(0,lote); // Añadir todo un ArrayList a partir de una posición.        
        System.out.println(numeros);
        
        System.out.println("\n___________________\n");        
        
        numeros.set(8,69); // pisa el número, lo reemplaza (el método no devuelve nada).
        System.out.println(numeros);
        
        System.out.println("\n___________________\n");        
        int elementoPos2 = (Integer)numeros.get(2); // se devuelve Object, hacer casting.
        System.out.println("ELEMENTO DEL INDICE 2 = " + elementoPos2);
        System.out.println(numeros);
        
        System.out.println("\n___________________\n");        
        
        System.out.println("¿TIENES UN 69? ... " + numeros.contains(69));
        System.out.println("¿TIENES UN 666? ... " + numeros.contains(666));
        
        System.out.println("\n___________________\n");        
        
        System.out.println("¿CUAL ES EL INDICE DEL 69? ... " + numeros.indexOf(69));
        // Si no encuentra un determinado elemento dará -1.
        System.out.println("¿CUAL ES EL INDICE DEL 666? ... " + numeros.indexOf(666));
        
        System.out.println("\n___________________\n");        
        
        System.out.println("¿ESTA VACIA LA COLECCIÓN? ... " + numeros.isEmpty());
        
        System.out.println("\n___________________\n");        
        
        System.out.println("¿CUANTOS ELEMENTOS TIENES? ... " + numeros.size()); // NO length.
        
        System.out.println("\n___________________\n");        
                
        /////////////////////////////////////////////
        Iterator it = numeros.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        /////////////////////////////////////////////        
        
        System.out.println("\n___________________\n");        
        
        Object[] losNumeros = numeros.toArray(); // obtener array de Object.
        for (Object object : losNumeros) {
            System.out.println("---> " + object);
        }
        
        System.out.println("\n___________________\n");        
        // si remove recibe un int (primitivo), borra por posición.
        numeros.remove(1);
        System.out.println(numeros);
        
        System.out.println("\n___________________\n");        
        // si remove recibe un Object, borra buscando por equals.
        numeros.remove(new Integer(-3));
        System.out.println(numeros);
        
        System.out.println("\n___________________\n");        
        numeros.clear(); // borra todo.
        System.out.println(numeros);
        
        System.out.println("EL HASHCODE DEL ARRAYLIST ... " + numeros.hashCode());
        System.out.println("TAMAÑO DEL ARRAYLIST ... " + numeros.size());
        
        System.out.println("\n_______ORDENACIÓN POR COLLLECTIONS _______\n");        
        
        //numeros.add("HOLA"); // NO MEZCLAR TIPOS O GENERARÁ EXCEPCIÓN.
        numeros.add(-3);
        numeros.add(5);
        numeros.add(2);
        
        Collections.sort(numeros); // Clase de utilidad del paquete java.util.        
        System.out.println(numeros); // los cambios se hacen sobre el original.   
    }   
}