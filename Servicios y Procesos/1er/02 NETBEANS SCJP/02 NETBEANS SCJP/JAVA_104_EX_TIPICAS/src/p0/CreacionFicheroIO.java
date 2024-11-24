// Crear una clase que intente generar un fichero de texto en el disco a través
// de la clase File. Comprobar cómo es en el momento de invocar al método
// createNewFile(), cuándo el sistema nos obliga a gestionar la posible
// excepción de tipo comprobativo IOException. Realizar dicha gestión mediante 
// la captura del tipo IOException en un bloque try-catch.

// El método createNewFile() declara que puede lanzar una excepción IOException:
// public boolean createNewFile() throws IOException {}

package p0;

import java.io.File;
import java.io.IOException;

public class CreacionFicheroIO {

    public static void main(String[] args) throws IOException {
        
        File fichero = new File("c:\\holamundo.txt");
        
        boolean exito = false;
        
        try {            
            exito = fichero.createNewFile();
            // si el fichero ya existe, no lo vuelve a crear ... devuelve false.
        } catch(IOException ioe) {
            System.out.println("ERROR AL CREAR EL FICHERO EN EL DISCO DURO");
            System.out.println(ioe);
        }
        
        System.out.println("¿EL FICHERO SE CREO CON EXITO? " + (exito?"SI":"NO"));
        
        System.out.println("\n\nFIN DE IMPRESION \n\n");   
    }    
}