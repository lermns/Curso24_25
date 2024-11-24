// Crear un Runnable que imprima por pantalla los caracteres comprendidos
// entre la letra A y la letra z utilizando un retardo de 200 milisegundos.

// Utilizar el constructor de Thread al que pasaremos un Runnable.


package Threads.Clase.JAVA_154_HILOS.p3;


public class CaracteresRunnable implements Runnable {

    @Override
    public void run() {
    
        for (char  c = 'A'; c <= 'z' ; c++) {
            System.out.println("----------> " + c);
            try {
                Thread.sleep(200); // ponte a dormir (NON-RUNNING-STATE) al menos 200 ms.
            } catch(InterruptedException ie) {
                System.out.println("ERROR ... " + ie);
            }
        }   
    }   

}