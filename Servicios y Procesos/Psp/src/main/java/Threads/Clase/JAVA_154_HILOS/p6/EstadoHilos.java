// Crear una clase que genere una instancia de la anterior clase hilo para
// comprobar el funcionamiento de los métodos isAlive, getState, getName y
// currentThread desde el método main, simplemente imprimiendo por pantalla
// el valor devuelto por dichos métodos.

// Nota: Thread.currentThread() devuelve una referencia al hilo actualmente
//       en ejecución. Si el hilo esta disponible o ejecutándose se indicará
//       a través del método getState RUNNABLE (RUNNING no existe).


package Threads.Clase.JAVA_154_HILOS.p6;


public class EstadoHilos {

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("SE CREA LA INSTANCIA DEL HILO");
        MiHilo h1 = new MiHilo();
        System.out.println("H1 ¿VIVO? ... " + h1.isAlive()); // false
        System.out.println("H1 ¿ESTADO? ... " + h1.getState()); // NEW
        
        System.out.println("\n\nSE ARRANCA EL HILO");
        h1.start();

        System.out.println("¿QUE HILO ESTA EN EJECUCION AHORA MISMO? ... ");
        System.out.println(Thread.currentThread().getName());
        
        System.out.println("H1 ¿VIVO? ... " + h1.isAlive()); // true
        System.out.println("H1 ¿ESTADO? ... " + h1.getState()); // RUNNABLE                
        //Nota: El estado RUNNING aparecerá como RUNNABLE.
        
        h1.join();
        System.out.println("\n\nEL HILO HA TERMINADO");

        System.out.println("H1 ¿VIVO? ... " + h1.isAlive()); // false
        System.out.println("H1 ¿ESTADO? ... " + h1.getState()); // TERMINATED                
    }    

}