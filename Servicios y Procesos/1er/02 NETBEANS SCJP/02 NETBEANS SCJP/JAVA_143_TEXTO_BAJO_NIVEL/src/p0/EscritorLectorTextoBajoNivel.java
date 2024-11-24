// Crear una clase que utilice flujos lectores y escritores de bajo nivel,
// en modo texto, para escribir cadenas de texto y posteriormente recuperarlas.

// Nota: Sólo los flujos del modo BINARIO, bajo o alto nivel, NO REQUIEREN HACER
//       USO DEL MÉTODO flush(). El resto, sean de alto o bajo nivel, SÍ.
//       En función del método utilizado para leer, se detectará el fichero
//       de una u otra forma (-1, EOFException, null ... ver la tabla de la teoría).


package p0;

import java.io.FileReader;
import java.io.FileWriter;


public class EscritorLectorTextoBajoNivel {

    // ATENCIÓN: Una vez demostrado en ejercicios anteriores qué excepciones
    //           pueden generarse y cómo tratarlas, nos limitaremos a lanzarlas
    //           fuera del método main. Habitualmente no es ésta la manera más 
    //           correcta de programar, pero de cara a facilitar la comprensión
    //           y el desarrollo de los siguientes ejercicios, se hará uso de ella.
    
    public static void main(String[] args) throws Exception {
        
        String fichero = "textoBajoNivel.txt";
        
        FileWriter escritor = new FileWriter(fichero);
        
        // Escribimos cadenas de texto (más fácil que caracteres sueltos).
        escritor.write("HOLA");
        escritor.write("\n");
        escritor.write("Y ADIOS");
        
        // Verter datos. Sólo los binarios de bajo nivel no necesitan hacer flush.
        escritor.flush();
        
        // cerrar.
        escritor.close();

        
        /////////////////////////////////////////////
        
        
        FileReader lector = new FileReader(fichero);
        
        int dato;
        String lasCadenas = "";
        
        // Se detectará el fin de fichero cuando se lea -1. Los enteros 
        // recuperados se van concatenando hasta obtener la cadena completa.
        // El lector modo texto de bajo nivel "no sabe" leer String. El
        // escritor "sí supo" escribirlos.
        while( (dato = lector.read()) != -1) {
            lasCadenas += (char)dato;
        }
        
        System.out.println("\nCADENAS LEIDAS ---> \n");
        
        System.out.println(lasCadenas);
           
        System.out.println("\nFIN DE IMPRESION\n");
        
    }   
}