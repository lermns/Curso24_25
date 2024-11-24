// Crear una clase que haga uso de java.io.PrintWriter (modo texto, alto nivel) 
// Comprobar como es capaz de conectarse a un dispositivo I/O sin necesidad de
// un flujo de bajo nivel. Escribir una simple frase para comprobar su correcto
// funcionamiento tanto con un fichero cómo con el flujo de consola.


package p0;

import java.io.PrintWriter;


public class ClasePrintWriter {

    public static void main(String[] args) throws Exception {
        
        String fichero = "ficheroDatos.txt"; // DISPOSITIVO I/O.
        
        // El constructor de PrintWriter admite diversos elementos:
        PrintWriter escritor = new PrintWriter(fichero);    // conexión a fichero.
        escritor.println("MASTER JAVA - VCG 2K13 - 1");
        escritor.flush();
        escritor.close();

        
        escritor = new PrintWriter(System.err);             // consola de error.        
        escritor.println("MASTER JAVA - VCG 2K13 - 2");
        escritor.flush();
        escritor.close();
        
        escritor = new PrintWriter(System.out);             // consola estandar.        
        escritor.println("MASTER JAVA - VCG 2K13 - 3");
        escritor.flush();
        escritor.close();
        
        System.out.println("\nFIN DE IMPRESION\n");        
    }   
    
}