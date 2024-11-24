// Crear una clase que implemente la interfaz Runnable. Definere el método
// run de forma que se muestre un simple mensaje por pantalla.


package Threads.Clase.JAVA_154_HILOS.p2;


public class MiRunnable implements Runnable {

    @Override
    public void run() {
        // Lo que hará el hilo al que le asociemos este Runnable (delegación).
        System.out.println("SOY UN HILO DE EJECUCION USANDO RUNNABLE: " + Thread.currentThread().getName());
    }

}