// Crear una clase que escriba en un fichero los caracteres existentes entre
// las letras A y z, omitiendo todos aquellos que nos sean letras.
// Utilizar un flujo escritor binario de bajo nivel.

// Nota: 65 ---> A   ...   122 ---> z.
//       La funcionalidad del bajo nivel es muy limitada.

package p1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class EscribirCaracteres {

    public static void main(String[] args) {
        
        // FLUJO ESCRITOR MODO BINARIO BAJO NIVEL.
        FileOutputStream escritor = null;
                
        try {
            
            String fichero = "caracteres.txt";

            // Reutilizar el fichero ya creado indicando true en el constructor:
            //escritor = new FileOutputStream("caracteres.txt",true);
            
            escritor = new FileOutputStream(fichero);
            
            for(char c='A'; c <= 'z'; c++) { // los char son números.                
                if(c>'Z' && c<'a') { // algunos caracteres que no son letras.
                    continue;
                }
                escritor.write(c);                
                escritor.write(' ');
            }            
        } catch(FileNotFoundException fnfe) {
            System.out.println("ERROR AL CREAR EL FICHERO");
            System.out.println(fnfe);
        } catch(IOException ioe) {
            System.out.println("ERROR AL ESCRIBIR LOS CARACTERES");
            System.out.println(ioe);
        } finally {
            if(escritor != null) {
                try {
                    escritor.close();
                } catch(IOException ioe) {
                    System.out.println("ERROR AL CERRAR EL FLUJO");
                    System.out.println(ioe);
                }
            }
        }
        
        System.out.println("\nFIN DE IMPRESION\n");
    }   
    
}