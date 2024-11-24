// Crear la clase ComparadorGenero (prestar atención a que películas distintas
// puede pertenecer al mismo género y que podría no añadirlas) que implementa
// la interfaz Comparator, para realizar una ordenación por género.


package comparadores;

import dvds.DVD;
import java.util.Comparator;

public class ComparadorGenero implements Comparator<DVD> {

    @Override
    public int compare(DVD dvd1, DVD dvd2) {

        int resultado = dvd1.getGenero().compareTo(dvd2.getGenero());
                
        // AVISO: Podremos tener más de 1 película con el mismo género, luego
        // tendremos que devolver algo distinto de 0 para que todas ellas se
        // añadan. Sólo en el caso de que el género, el precio y el TÍTULO (ésto
        // si debería ser único, como la clave primaria de una base de datos), no
        // se añadirá si ya hay una en el conjunto. Ejemplo:                        
        
        // 2 películas distintas por título ("Sphere" y "Dune") son
        // iguales por género ("ciencia ficción") lo que provocaría
        // que no se agregase la segunda ("Dune"). Para evitar ésto,
        // se devuelve un valor fijo distinto de 0.
        
        // Si ordenamos por título, como no quemos 2 películas iguales
        // ("Sphere" y "Sphere"), no tendríamos que vigilar la anterior
        // situación.
        
        if (resultado == 0) { // mismo género ... PERO AÑADIRLA DE TODAS FORMAS.
            return -1; // o lo que se quiera (-453, -505, +22 ... etc pero NO 0).    
        }
        
        return resultado;        
    }

}