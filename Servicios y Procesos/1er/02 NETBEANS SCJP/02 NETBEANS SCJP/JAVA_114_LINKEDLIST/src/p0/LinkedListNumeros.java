// Crear una clase que haga uso de los métodos principales de LinkedList (lista
// simplemente enlazada).

// add, offer, push .... añaden un elemento a la colección.
// get, peek ........... consultan un elemento de la colección (no lo quitan).
// remove, poll, pop ... extraen el elemento de la colección, lo quitan.


package p0;

import java.util.LinkedList;


public class LinkedListNumeros {

    public static void main(String[] args) {
        
        LinkedList numeros = new LinkedList();
        
        numeros.add(15); // añadir (a continuación del último existente).
        numeros.offer(19); // añadir, igual que add.
        
        System.out.println(numeros);
        
        System.out.println("\n__________________\n");
        
        numeros.addFirst(6); // añadir al principio.
        numeros.offerFirst(7); // añadir al principio, como el anterior.

        System.out.println(numeros);
        
        System.out.println("\n__________________\n");
        
        numeros.addLast(-6); // añadir al final.        
        numeros.offerLast(-7);// añadir al final, como el anterior.
        
        numeros.add(45);

        System.out.println(numeros);        
        
        System.out.println("\n__________________\n");

        System.out.println("---> " + numeros.peek()); // consultar el primero.
        System.out.println("---> " + numeros.peekFirst()); // consultar el primero.

        System.out.println("---> " + numeros.peekLast()); // consultar el último.
        System.out.println("---> " + numeros.peekLast()); // vemos que no lo quita.
        
        System.out.println("\n______ EXTRACCIONES, QUITAR EL ELEMENTO _______\n");        

        System.out.println("---> " + numeros);
        
        System.out.println("quita ---> " + numeros.poll()); // saca el primero (lo quita).
        System.out.println("quita ---> " + numeros.pollFirst()); // saca el primero.

        System.out.println("quita ---> " + numeros.pollLast()); // saca del último.
        System.out.println("quita ---> " + numeros.pollLast());// vemos que no es el de antes.
        
        System.out.println(numeros);        
        
        System.out.println("\n_______ PUSH - LIFO - PILA ________\n");
        
        numeros.clear(); // borra todo.
        
        for (int i = 1; i <= 10; i++) {
            numeros.push(i); // añadir al principio (empujar) ... "bala en cargador". 
        }
        
        System.out.println(numeros);
        
        System.out.println("\n_______ POP - LIFO - PILA ________\n");
        
        for (int i = 1; i <= 10; i++) {
            System.out.print(numeros.pop() + " "); // quitar del principio
        }
        
        System.out.println("\n" + numeros);
        System.out.println("TOTAL ELEMENTOS EN EL L.L ... " + numeros.size());
        
        // PUSH+POP ... EQUIVALE A PILA ... LIFO ... "SACOS CEMENTO" O "BALAS CARGADOR".
        
        // AÑADIMOS Y QUITAMOS DEL PRINCIPIO.
    }
}