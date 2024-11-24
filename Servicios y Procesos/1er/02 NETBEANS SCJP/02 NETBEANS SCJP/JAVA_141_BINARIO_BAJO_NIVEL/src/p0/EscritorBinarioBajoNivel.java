// Crear una clase que escriba en un fichero los caracteres 'ABA'. Utilizar
// para ello un flujo escritor binario de bajo nivel (FileOutputStream),
// controlando mediante bloques try-catch las posibles excepciones que se
// puedan lanzar. Provocar el cierre del flujo en la claúsula finally del
// último bloque try-catch.

// Nota: Cerrar siempre los flujos a voluntad, si esperar que éstos se cierren
//       de forma indirecta.


package p0;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class EscritorBinarioBajoNivel {
    
    public static void main(String[] args) {
        
        FileOutputStream escritor = null;

        // Crear el fichero en la ruta del proyecto actual.
        // Una vez creado, buscarlo en la pestaña Files.
        // Se utiliza el constructor que no pide el booleano
        // (append), luego el fichero se crea cómo nuevo cada vez.        
        try {
            escritor = new FileOutputStream("fichero1.txt");
            //escritor = new FileOutputStream("fichero1.txt", true); //si ponemos el true, añade al fichero
        } catch(FileNotFoundException fnfe) {
            // El constructor puede lanzar una excepcion FNFE.
            System.out.println("ERROR AL CREAR/ABRIR EL FICHERO");
        }

        // UTILIZA CÓDIGO UNICODE.
        // Empleamos el método write(int). A pesar de que indica int (32 bits),
        // sólo utilizarán los 8 bits más bajos (el resto se descartan). 
        // El octavo bit (bit b7 - MSB) NO ES DE SIGNO, sino un bit de datos. 
        // Son bytes puros y NO el tipo byte de Java (-128 -> +127).
        try {
            // ESCRIBIR UNICODE:
            int codigoLetraA = (int)'A'; // casting directo de char a int. Son números.        
            escritor.write(codigoLetraA); // 65 ---> 01000001 ---> 'A'.
            escritor.write(66); // B            
            escritor.write(3905); // 3905 -> 111101000001 -> 01000001 (8 más bajos) -> 65 -> A.
        } catch(IOException ioe) {
            System.out.println("ERROR AL ESCRIBIR LOS DATOS");
            System.out.println(ioe);
        } finally {
            // CERRAR EL FLUJO:
            try {
                if(escritor != null) { // comprobar que no es null para evitar NullPointerException.
                    escritor.close();
                }
            } catch(IOException ioe) {
                System.out.println("ERROR AL CERRAR EL FLUJO ESCRITOR");
                System.out.println(ioe);
            }
        }
        
        System.out.println("!!!MIRA EL FICHERO GENERADO!!! ... ABA\n");
        System.out.println("\nFIN DE IMPRESION\n");
    }   

}