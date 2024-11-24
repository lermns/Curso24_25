// Crear una clase que genere una instancia de un hilo (Thread) a partir de
// una instancia de un Runnable (una clase que implemente la interfaz
// java.lang.Runnable, la cuál a su vez obliga a implementar el método
// public void run()). Utilizar para ello la sobrecarga del constructor de
// Thread que pide como parámetro de entrada un Runnable. 

// Nota: Mediante esta técnica no se pierde la posibilidad de emplear más
//       tarde la herencia.


package p2;


public class HiloRunnable {

    public static void main(String[] args) {

        // paso a paso:
        // MiRunnable mr = new MiRunnable();
        // Thread hilo = new Thread(mr);
              
        // todo en la misma línea.
        Thread hilo = new Thread(new MiRunnable());
        
        // se arranca el hilo y se llama implícitamente al run() de Runnable.
        hilo.start(); 
    }

}