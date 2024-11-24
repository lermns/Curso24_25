// Crear una pareja de hilos constituida por las anteriores clases
// NumerosThread y CaracteresRunnable. Ejecutar el método start de 
// cada uno de ellos y ver como la salida que ambos generan por
// pantalla aparece mezclada (al hacerse sleep, el Scheduler conmutará
// el hilo actual).


package p3;


public class EjecucionParalela {

    public static void main(String[] args) {
        
        Thread hilo1 = new NumerosThread();
        Thread hilo2 = new Thread(new CaracteresRunnable());
        
        hilo1.start(); // retardo sleep 100 ms.
        hilo2.start(); // retardo sleep 200 ms.        
    }    

}