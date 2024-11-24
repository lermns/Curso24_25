// Crear la clase Trazador para implementar el sistema de trazas en base a una 
// clase PrintWriter. Se le conectará un flujo escritor, modo binario, de bajo
// nivel (FileOutputStream) para mostrar una de las muchas posibilidades de 
// conexión de dicha clase (cómo ya se ha explicado, ésto no sería necesario).


package p0;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;


public class Trazador {

    private static final String FICHERO;
    private static PrintWriter escritorPrintWriter;
    private static FileOutputStream escritorBajoNivel;

    
    static {
        FICHERO = "ficheroTrazas";

        try {
            // utilizar el modo append para no borrar lo anterior:
            // en este caso, utilizaremos un flujo binario de bajo nivel para
            // comprobar cómo PrintWriter puede hacer uso de él.
            escritorPrintWriter = 
                new PrintWriter(new FileOutputStream(FICHERO, true));
        } catch (FileNotFoundException fnfe) {
            System.out.println("ERROR, NO SE PUEDE ABRIR EL FICHERO");
            System.out.println(fnfe);
        }
    }

    
    // Traza cuando no ha habido ningún error.
    public static void escribirTraza(String operacion, double x, double y, double resultado) {
        String fecha = new Date().toString();
        escritorPrintWriter.println("\n___________________ TRAZA ___________________\n");
        escritorPrintWriter.println("[" + fecha + "] ... [" + operacion + "] ... "
                + "[operador = " + x + "]" + " ... " + "[operador = " + y + "]"
                + " ... " + "[resultado = " + resultado + "]");
        escritorPrintWriter.println("\n_____________________________________________\n");        
        escritorPrintWriter.flush();
    }

    
    // Traza cuando ha habido un error (excepcion).
    public static void escribirTraza(String error) {
        String fecha = new Date().toString();
        escritorPrintWriter.println("\n___________________ TRAZA ___________________\n");
        escritorPrintWriter.println("[" + fecha + "]" + " >> ERROR >> " + error);
        escritorPrintWriter.println("\n_____________________________________________\n");        
        escritorPrintWriter.flush();
    }

}