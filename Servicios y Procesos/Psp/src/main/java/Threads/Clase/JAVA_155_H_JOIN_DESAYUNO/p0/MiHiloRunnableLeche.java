package Threads.Clase.JAVA_155_H_JOIN_DESAYUNO.p0;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MiHiloRunnableLeche implements  Runnable{

    @Override
    public void run() {
        System.out.println("Calentando la leche...");
        try {
            Thread.sleep(200); // ponte a dormir (NON-RUNNING-STATE) al menos 200 ms.
        } catch(InterruptedException ie) {
            System.out.println("ERROR AL CALENTAR LA LECHE... " + ie);
            Logger.getLogger(MiHiloThreadTostadas.class.getName()).log(Level.SEVERE, null, ie);
        }
        System.out.println("TU LECHE ESTÁ CALENTITA!!!!!!");

    }   
}
