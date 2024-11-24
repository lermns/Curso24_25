package Threads.Clase.HilosEjemplosPedro;

/**
 *
 * @author pedbo
 *
 */
public class Proceso2 implements Runnable {

    @Override
    public void run() {
        //synchronized (this) {     //Añadiendo esto se intercalan.
            for (int i = 0; i <= 5; i++) {
                System.out.println("Proceso 2");
            }
        //}
    }
}
