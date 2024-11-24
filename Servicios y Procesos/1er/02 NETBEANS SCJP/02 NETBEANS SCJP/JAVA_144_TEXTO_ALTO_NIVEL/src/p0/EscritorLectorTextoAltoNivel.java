package p0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class EscritorLectorTextoAltoNivel {

    public static void main(String[] args) throws Exception {
        
        String fichero = "cadenasTexto.txt";

        ////////////////////////// ESCRITOR ////////////////////////////////        
        
        FileWriter escritorBajoNivel = new FileWriter(fichero);
        BufferedWriter escritorAltoNivel = new BufferedWriter(escritorBajoNivel);
     
        escritorAltoNivel.write("EL BRINDIS DEL BUEN VINO ...\n");
        escritorAltoNivel.write("   ... ACOMPAÑADO DE QUESO Y JAMÓN");
        
        // Verter los datos. Le obligará al flujo de bajo nivel a hacerlo.
        escritorAltoNivel.flush();
        
        // Cierre implícito de los flujos asociados de bajo nivel al cerrar el alto.
        escritorAltoNivel.close();
        
        ////////////////////////// LECTOR ////////////////////////////////
        
        FileReader lectorBajoNivel = new FileReader(fichero);
        BufferedReader lectorAltoNivel = new BufferedReader(lectorBajoNivel);

        String cadenaLeida = "";
        String lecturaTotal = "";
        
        // Detectar fin de fichero con null a través del método readLine.
        // El lector de alto nivel modo texto SÍ puede leer cadenas, cosa
        // que el de bajo no podía (recuperaba enteros -Unicode- hasta detectar -1).
        while( (cadenaLeida = lectorAltoNivel.readLine()) != null) {
            System.out.println("CADENA LEIDA ---> " + cadenaLeida + "\n");
            lecturaTotal += cadenaLeida + "\n";
        }
        
        System.out.println("\n\nCONJUNTO TOTAL DE CADENAS LEIDAS ... \n");
        System.out.println(lecturaTotal);
        
        lectorAltoNivel.close(); // cierre implícito de los bajos.
    }   
    
}