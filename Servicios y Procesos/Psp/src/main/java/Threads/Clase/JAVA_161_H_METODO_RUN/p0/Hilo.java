// Crear una clase Hilo que herede de Thread, sobrescribiendo su método run
// para imprimir por pantalla un mensaje simple.


package Threads.Clase.JAVA_161_H_METODO_RUN.p0;


public class Hilo extends Thread {

    @Override
    public void run() {
        System.out.println("EJECUCIÓN DEL METODO RUN");
    }    
    
}