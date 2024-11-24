// Crear un hilo que imprima por pantalla los 100 primeros números [0..99]
// en intervalos de 100 milisegundos. Utilizar el método sleep de retardo de 
// la clase Thread gestionando la posible interrupción InterruptedException. 
// (pertence al paquete java.lang, luego no es necesario importarla).

// Emplear una clase que herede de Thread.


package Threads.Clase.JAVA_154_HILOS.p3;

public class NumerosThread extends Thread {

    @Override
    public void run() {
     
        for (int i = 0; i < 100; i++) {
            System.out.println("---> " + i);            
            
            // sleep, wait y join pueden lanzar la interrupción 
            // comprobativa: InterruptedException.
            try {
                Thread.sleep(100); // ponte a dormir al menos 100 ms.
            } catch(InterruptedException ie) {
                System.out.println("ERROR ... " + ie);
            }
        }
    }   

}