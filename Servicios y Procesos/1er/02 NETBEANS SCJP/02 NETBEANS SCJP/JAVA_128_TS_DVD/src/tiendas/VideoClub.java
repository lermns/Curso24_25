// Crear la clase VideoClub que genere distintas instancias de DVD y las
// almacene en un TreeSet. Se utilizarán distintos comparadores al crear
// la colección, mostrando por pantalla cómo quedan almacenados. Así mismo,
// se podrá recurrir a no usar ninguno de los comparadores, en cuyo caso la
// ordenación se realizará por precio a través de la implementación del 
// método compareTo de la interfaz Comparable (clase DVD).

// Nota: al construir el objeto TreeSet, como parámetro de entrada al
//       constructor, podemos decidir el uso o no de un determinado
//       comparador. Si no indicamos nada, se utilizará la definición
//       del método compareTo de los elementos de la colección para 
//       realizar la ordenación de los mismos, pero si se le pasa
//       la instancia de un comparador, se realiza dicha ordenación
//       en base a la definición del método compare del comparador,
//       SIN IMPORTAR LO QUE INDIQUE EL MÉTODO compareTo de los 
//       elementos.


package tiendas;

import comparadores.ComparadorFull;
import comparadores.ComparadorGenero;
import comparadores.ComparadorTitulo;
import static enumerados.Generos.*;
import dvds.DVD;
import java.util.TreeSet;

public class VideoClub {

    public static void main(String[] args) {
        
        DVD d1 = new DVD("SPHERE",          FICCION,    18.99);
        DVD d2 = new DVD("AMERICAN PIE 2",  COMEDIA,    13.22);
        DVD d3 = new DVD("AMERICAN PIE 3",  COMEDIA,    14.22);
        DVD d4 = new DVD("LA ROCA",         ACCION,     10.40);
        DVD d5 = new DVD("SAW",             TERROR,     15.30);
        
        TreeSet<DVD> peliculas = null; // aquí se guardarán los DVD.

        // ELEGIR LA OPCIÓN PARA ORDENAR (usar un char para el bloque switch):
        // precio,titulo,genero,full;
        
        char opcion = 'p'; 
        //char opcion = 't';
        //char opcion = 'g';
        //char opcion = 'f';
        
        switch(opcion) {
            case 'p': // usará Comparable y precio. No usa ningún comparador.
                peliculas = new TreeSet<DVD>(); 
                break;
                
            case 't': // usará Comparador de título.
                peliculas = new TreeSet<DVD>(new ComparadorTitulo());
                break;
                
            case 'g': // usará Comparador de género.
                peliculas = new TreeSet<DVD>(new ComparadorGenero());
                break;

            case 'f': // usará Comparador full = Comparable + Comparator's.
                peliculas = new TreeSet<DVD>(new ComparadorFull());
                break;
        }
                
        peliculas.add(d1);
        peliculas.add(d2);
        peliculas.add(d3);
        peliculas.add(d4);
        peliculas.add(d5);
        
        System.out.println(peliculas);
        
        
        // DESCOMENTAR Y PROBAR ESTA OTRA COMBINACIÓN:
        
        
//        System.out.println("\n\n\n_____ MISMO GENERO Y PRECIO, TITULO DISTINTO _____\n");
//        
//        // precio --> titulo --> genero
//        peliculas = new TreeSet<DVD>(new ComparadorFull());
//        
//        DVD dvd_1 = new DVD("AMERICAN PIE 2",  COMEDIA,    13.22);
//        DVD dvd_2 = new DVD("AMERICAN PIE 3",  COMEDIA,    13.22);
//
//        peliculas.add(dvd_1);
//        peliculas.add(dvd_2);
//        
//        System.out.println("SE USA COMPARADOR FULL: PRECIO --> TITULO --> GENERO: \n");
//        
//        System.out.println(peliculas);        
//        
//        System.out.println("\n");
    }   

}