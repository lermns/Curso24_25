// Crear la clase Amigos para generar distintos objetos de Persona. Añadir
// los mismos a una instancia de TreeSet (ordenación natural, no repetidos) y
// observar cómo al realizar la impresión por pantalla se ordenan éstos en
// base al comportamiento definido en el método compareTo de Persona. De
// igual forma, comprobar cómo es dicho método el que determina si el elemento
// existe ya dentro del TreeSet, evitando en tal caso que se le pueda añadir
// (no llama a equals ni a hashCode).


package p0;

import java.util.TreeSet;


public class Amigos {

    public static void main(String[] args) {
        
        TreeSet<Persona> personas = new TreeSet<Persona>();
        
        Persona p1 = new Persona("PEDRO");
        Persona p2 = new Persona("JUAN");
        Persona p3 = new Persona("ANA");
               
        personas.add(p1); // el primero introducido se compara con si mismo.
        personas.add(p2);
        personas.add(p3);

        System.out.println("\n >>> INTENTAR VOLVER A INTRODUCIR UN NUEVO OBJETO PEDRO <<< \n");
        Persona p4 = new Persona("PEDRO"); // REPETIDO, no se añadirá.
        personas.add(p4); // el último se compara con todos.
       
        
        System.out.println(personas);   
    }    

}