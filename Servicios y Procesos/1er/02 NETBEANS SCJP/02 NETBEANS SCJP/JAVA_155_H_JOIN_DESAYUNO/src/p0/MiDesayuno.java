package p0;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MiDesayuno {
    public static void main(String[] args) {
        Thread hilo1 = new MiHiloThreadTostadas();
        Thread hilo2 = new Thread(new MiHiloRunnableLeche());
        
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
             hilo2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MiDesayuno.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("DESAYUNO LISTO");
        
        
        
    }
      
}
