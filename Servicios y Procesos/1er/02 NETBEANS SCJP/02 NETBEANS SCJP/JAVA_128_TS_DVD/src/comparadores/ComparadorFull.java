// Crear la clase ComparadorFull que implementa la interfaz Comparator,
// para realizar una ordenación por precio, a continuación por titulo y
// por último por género.

// Nota: Se realiza la comparación por precio y si ambos precios son iguales,
//       se procede a comparar por título y así sucesivamente hasta el final.


package comparadores;

import dvds.DVD;
import enumerados.Generos;
import java.util.Comparator;

// Este comparador mira por PRECIO, luego por TÍTULO y por último, por GÉNERO.
public class ComparadorFull implements Comparator<DVD> {

    @Override
    public int compare(DVD dvd1, DVD dvd2) {
        
        System.out.println("SE LLAMA AL METODO COMPARE");
        
        // 1 - MIRAR POR PRECIO (Double)
        System.out.println("DVD1 PRECIO = " + dvd1.getPrecio());
        System.out.println("DVD2 PRECIO = " + dvd2.getPrecio());
        
        if(dvd1.getPrecio().doubleValue() == dvd2.getPrecio().doubleValue()) {
            
            System.out.println("MISMO PRECIO\n\n");            

            // 2 - MIRAR POR TÍTULO (String)
            System.out.println("DVD1 TITULO = " + dvd1.getTitulo());
            System.out.println("DVD2 TITULO = " + dvd2.getTitulo());            
        
            if(dvd1.getTitulo().equals(dvd2.getTitulo())) {
            
                System.out.println("MISMO TITULO\n\n");

                // 3 - MIRAR POR GÉNERO (enumerado Generos)
                System.out.println("DVD1 GENERO = " + dvd1.getGenero());
                System.out.println("DVD2 GENERO = " + dvd2.getGenero());                            
     
                if(dvd1.getGenero() == dvd2.getGenero()) {
                    
                    System.out.println("\nSE DETECTA REPETIDO ... NO AÑADIR " + dvd2 + "\n\n");
                    return 0; // SON IGUALES ... NO AÑADIR
                }                
                System.out.println("\nLOS GENEROS SON DISTINTOS\n");
                return dvd1.getGenero().compareTo(dvd2.getGenero());
            }
            System.out.println("\nLOS TITULOS SON DISTINTOS\n");
            return dvd1.getTitulo().compareTo(dvd2.getTitulo());
        }
        System.out.println("\nLOS PRECIOS SON DISTINTOS\n");
        return dvd1.getPrecio().compareTo(dvd2.getPrecio());
    }

}