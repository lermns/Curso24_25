// Crear una clase que muestre como a partir de un Scanner se puede tokenizar
// una cadena de texto, es decir, separar su contenido en base a un delimitador.


package p0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class CortarCadena {

    // Método para visualizar los datos del List (reutilizar).
    private static void visualizar(List listado) {
        
        System.out.println("\n__________________________________\n");
        
        Iterator it = listado.iterator();
        
        while(it.hasNext()) {
            System.out.println("---> " + it.next());
        }
        
        System.out.println("\n__________________________________\n");
    }
    
    
    public static void main(String[] args) {
        
        // Creamos la cadena que más tarde separaremos en tokens.
        // TRUe, fALSe ... se recuperan como true y false.

        String cadena = "false 123 TRUe HOLA 666 adios";
        
        System.out.println(cadena + "\n");
        
        // Flujo de lectura Scanner al que le pasamos la anterior cadena.
        Scanner sc = new Scanner(cadena);
        
        // Establecer el delimitador (por defecto es el espacio en blanco).
        sc.useDelimiter(" ");
        
        // Crear los List dónde se almacenaran los tokens separados por tipo.
        ArrayList<Boolean> booleanos = new ArrayList<Boolean>();
        ArrayList<Integer> enteros = new ArrayList<Integer>();
        ArrayList<String> cadenas = new ArrayList<String>();
        
        // EL DELIMITADOR SEPARA LOS TOKENS O TROZOS DE LA CADENA UNOS DE OTROS,
        // EL BUCLE WHILE LOS VA RECORRIENDO DE 1 EN 1.
        while(sc.hasNext()) { // repite mientras tengas más elementos.
            if(sc.hasNextBoolean()) { // ¿el siguiente es booleano?.
                booleanos.add(sc.nextBoolean()); // dámelo como booleano.
            } else if(sc.hasNextInt()) { // ¿int?.
                enteros.add(sc.nextInt()); // dámelo como int.
            } else {
                cadenas.add(sc.next()); // String
                //cadenas.add(sc.nextLine()); // coge todo lo que quede.
            }
        }
    
        System.out.println("SE HA SEPARADO LA CADENA EN ITEMS\n");
        
        visualizar(booleanos);
        visualizar(enteros);
        visualizar(cadenas);
        
        System.out.println("\n");
    }   
    
}