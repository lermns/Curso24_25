// Crear un instancia de java.lang.Thread y ejecutar su método start para
// comprobar qué sucede (el run() de Thread no hace nada).

// La clase Thread dispone de un atributo privado de tipo Runnable, que es
// llamado desde el método run de Thread si se detecta que no está a null. 
// En caso contrario, se puede observar como no hace absolutamente nada:


//    /* What will be run. */
//    private Runnable target;

//    @Override
//    public void run() {
//        if (target != null) {
//            target.run();
//        }
//    }

package p0;


public class HiloThread {

    public static void main(String[] args) {
        
        // instanciar la clase Thread.
        Thread hilo = new Thread(); 
        
        // arrancar el hilo:
        // se genera hilo de ejecución (instancia IS-A Thread + pila de ejecución particular).
        // El hilo REAL generado pasa a ser planificado, gestionado, por el SCHEDULER (el C.C.P).
        hilo.start(); 
        
        // No sucede absolutamente nada, ya que la implementanción
        // del método está vacia.        
        
        // Distinguir entre lo que es un HILO (instancia a secas) y un 
        // HILO DE EJECUCIÓN (lo anterior pero gestionado por el Scheduler,
        // el cuál asociará a la instancia una pila de ejecución ... memoria
        // temporal y exclusiva para que ese hilo guarde en ella su información.    
    }   
    
}