// Crear una clase que realice la importación estática de la variable valor 
// correspondiente a las clases Valores1 y Valores2, pero mediante el uso
// del comodin (de esta forma no se especifica ningún elemento en particular,
// sino que se da permiso de importación a todos los estáticos de la ruta
// indicada ... ¡ojo!, no así con los subpaquetes de la misma). Comprobar
// cómo la importación en si no genera error de compilación, pero al tratar
// de usar dicha variable valor, que está en ambas clases, el sistema genera
// un error por ambiguedad.


package p6;

import static p5.Valores1.*; // importaciones no generan el error.
import static p5.Valores2.*;

public class ErroresImportEstatica_2 {

    public static void main(String[] args) {
        
        // es al tratar de usar variables del mismo nombre cuando se genera el error.
        //System.out.println("el valor es ... " + valor);        
    }
    
}