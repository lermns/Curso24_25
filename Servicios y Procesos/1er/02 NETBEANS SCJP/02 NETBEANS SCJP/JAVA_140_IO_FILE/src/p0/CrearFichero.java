// Crear una clase que muestre la forma en la que se puede generar un fichero
// en el disco duro mediante el uso de java.io.File. Comprobar qué excepciones
// se pueden lanzar y cómo es necesario invocar al método createNewFile para 
// que el sistema trate de generarlo (File es sólo una representación del
// futuro fichero físico, de modo que al llamarse a su constructor, el fichero
// no es aún generado).


package p0;

import java.io.File;
import java.io.IOException;


public class CrearFichero {
    
    public static void main(String[] args) {

        // Es necesario utilizar el caracter de escape(\) para indicar que
        // el \ mostrado en el String se tome como una barra de directorio.
        // Así, \\ indicará al sistema que es el caracter '\'.
        File fichero = new File("C:\\FICHERO_1.TXT"); // fichero aún sin crear.
  
        boolean creado = false;
        
        try {
            // Crear el fichero (si puedes). Se devuelve un boolean.
            // Si el sistema detecta que ya existe, no lo volverá a crear.
            creado = fichero.createNewFile();
        } catch(IOException ioe) {
            // Si no disponemos de permisos para escribir en el disco duro
            // nos generará una excepción IOException.
            System.out.println("ERROR AL CREAR EL FICHERO");
            System.out.println(ioe);
            // Es posible que Windows no permita crear el fichero en la raíz de C.
            // Utilizar un directorio y crearlo dentro de él: "C:\\PRUEBAS\\FICHERO_1.TXT"
        }
        
        System.out.println("¿SE HA CREADO EL FICHERO? ... " + creado);
        
        System.out.println("\nFIN DE IMPRESION\n");
    }
    
}