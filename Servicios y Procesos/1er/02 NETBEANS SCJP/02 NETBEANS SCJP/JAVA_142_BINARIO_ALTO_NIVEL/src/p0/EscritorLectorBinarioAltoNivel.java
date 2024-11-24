// Crear una clase que haga uso del escritor y lector en modo binario alto
// nivel (requerirá de su correspondiente bajo nivel) para escribir distintos
// números enteros en un fichero y posteriormente leerlos.

// Nota: La funcionalidad de un bajo nivel es escasa, pobre, por lo que se puede
//       recurrir a un alto nivel para ampliarla. Todo se basa en un patrón
//       de diseño conocido como Decorator, en el que se dota a la nueva clase
//       de un mayor conjunto de métodos pero de forma que éstos, en última
//       instancia, hagan uso de los ya implementados en el objeto de la 
//       clase que reciben como parámetro y a la que se encargan de "decorar".

//       Así, se crea el dispositivo I/O (File o Socket). A continuación se
//       crea el flujo de bajo nivel y "enganchamos" éste al dispositivo I/O.
//       Para finalizar, se crea el flujo de alto nivel y "enganchamos" éste
//       al de bajo nivel (el de alto estará indirectamente conectado al I/O).

//       Se realiza por tanto un proceso en cadena a través de los constructores
//       de las distintas clases. Los datos que genera el de alto nivel se los pasa
//       al de bajo nivel y éste los introduce finalmente en el dispositivo I/O.

//       MUY IMPORTANTE: salvo la clase PrintWriter, el resto de flujos de
//       alto nivel (lector o escritor) NO PUEDEN CONECTARSE DIRECTAMENTE A
//       UN DISPOSITIVO I/O. Se pensaron sólo para "hacer las cosas más fáciles".


package p0;

import java.io.*;


public class EscritorLectorBinarioAltoNivel {

    public static void main(String[] args) throws Exception { // NO SE DEBE HACER ASÍ (PRUEBA)
        
        String fichero = "numerosInt.txt";
                
        ///// ESCRITOR HL(LL(I/O))/////
        
        // Escritor binario bajo nivel (le conectamos al fichero (dispositivo I/O):
        FileOutputStream escritorBajoNivel = new FileOutputStream(fichero);
        
        // Escritor binario alto nivel (le pasamos el anterior .. PATRÓN DECORATOR).
        // Por si sólo, no es capaz de conectarse al dispositivo I/O (el File o Socket).
        DataOutputStream escritorAltoNivel = new DataOutputStream(escritorBajoNivel);
        
        escritorAltoNivel.writeInt(666); // escritura de números enteros reales.
        escritorAltoNivel.writeInt(123456789);
        escritorAltoNivel.writeInt(65535);
        

        
        ///// LECTOR HL(LL(I/O)) /////     
        
        
        
        // SE DETECTA EL FINAL DE FICHERO CON EXCEPCIÓN EOFileException (end of file) //
        
        // Lector binario de bajo nivel (le conectamos al fichero (dispositivo I/O):
        FileInputStream lectorBajoNivel = new FileInputStream(fichero);

        // Lector binario de alto nivel (le pasamos el anterior .. PATRÓN DECORATOR).
        DataInputStream lectorAltoNivel = new DataInputStream(lectorBajoNivel);
        
        int dato = 0;
                
        try {
            while(true) { // bucle infinito ...
                dato = lectorAltoNivel.readInt();
                System.out.println("LEIDO ---> " + dato);
            }
        } catch(EOFException eof) { // ... roto por generación de excepción (fin fichero).
            System.out.println("ALCANZADO EL FINAL DEL FICHERO");
        } finally {
            System.out.println("CERRAMOS EL FLUJO");            
            // Cerrar primero el de alto nivel o los datos no vertidos del
            // de alto nivel, se quedarán encerrados en él al cerrar el 
            // de bajo nivel. Un cierre del de alto nivel provoca el cierre
            // a continuación, de forma automática, de los flujos de bajo 
            // nivel que tenga éste asociados. El cierre del de bajo nivel
            // NO PROVOCA el vertido de datos del de alto nivel asociado a él.
            
            lectorAltoNivel.close(); // Primero el de alto nivel ...
            lectorBajoNivel.close(); // y a continuación el de bajo.
        }
        
        System.out.println("\nFIN DE IMPRESION\n");
    }
    
}