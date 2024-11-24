package Threads.Clase.JAVA_155_H_JOIN_DESAYUNO.p0;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MiHiloThreadTostadas extends Thread{
    
    public void run(){
        System.out.println("Preparando las TOSTADAS...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("--------->ERROR PREPARANDO LAS TOSTADAS!!!");
            Logger.getLogger(MiHiloThreadTostadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("--- TOSTADAS LISTAS ---");
        
    }
    
}
