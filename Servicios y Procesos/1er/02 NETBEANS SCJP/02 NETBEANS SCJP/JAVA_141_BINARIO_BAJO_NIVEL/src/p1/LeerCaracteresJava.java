// Crear una clase para leer el fichero generado anteriormente, utilizando
// para ello una flujo lector binario de bajo nivel (detecta fin de fichero
// con -1). Imprimir por pantalla el contenido leído.


package p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class LeerCaracteresJava {

    public static void main(String[] args) {
        
        String fichero = "caracteres.txt";
        
        FileInputStream lector = null;
        
        try {
            lector = new FileInputStream(fichero);
            int dato = 0;
            
            // DETECTAR FIN DE FICHERO EN MODO BINARIO BAJO NIVEL LECTURA:
            // LEER HASTA QUE SE DETECTE -1 (!ojo!, no es el -1 numérico sino
            // un caracter de control. Método principal int read().
            while( (dato = lector.read()) != -1) {
                if(dato == ' ') {
                    continue;
                }
                // convertir el int leído a un char (cogemos los 8 bits LSB (más bajos).
                System.out.println("HE LEIDO ... " + dato + " ---> " + (char)dato);
            }
        } catch(FileNotFoundException fnfe) {
            System.out.println("ERROR AL INTENTAR ABRIR EL FICHERO");
        } catch(IOException ioe) {
            System.out.println("ERROR AL LEER EL FICHERO");
        } finally {
            try {
                if(lector != null) {
                    lector.close();
                }
            } catch(IOException ioe) {
                System.out.println("ERROR DE LECTURA DEL FICHERO");
            }
        }   
    }   
    
}