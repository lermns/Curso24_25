// Crear una clase que mediante el uso de java.io.File cree un directorio
// en el sistema


package p1;

import java.io.File;


public class CrearDirectorio {

    public static void main(String[] args) {
        
        // Se utiliza File para representar ficheros y directorios.
        File miDirectorio = new File("c:\\MI_DIRECTORIO");
        
        // A diferencia de createNewFile, mkdir NO LANZA ninguna excepción.
        // Cómo en el caso anterior, se devuelve un boolean.
        // Si el sistema detecta que el directorio ya existe, no lo volverá a crear.
        boolean creado = miDirectorio.mkdir();
        
        System.out.println("¿DIRECTORIO CREADO? ... " + creado);
        
        System.out.println("\n FIN DE IMPRESION \n");        
    }    
    
}