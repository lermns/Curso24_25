// Crear una clase Cuaderno como recurso compartido para ser usado por diversos
// hilos. Se definen en dicha clase los métodos escribir y leer, ambos en modo
// sincronizado a nivel de método (se usará la llave this con lo que se bloquean
// todos los métodos síncronos de la clase que usen dicha llave). Así, si uno de
// los hilos está escribiendo, el otro tenga que esperar para leer y viceversa.
// Establecer un retardo de 4 segundos para lectura y escritura, la cuál se 
// simboizará con un simple mensaje por pantalla.


package Threads.Clase.JAVA_156_H_SINCRONIZACION.p1;


public class Cuaderno {

    // sincronización a nivel de método. LLave utilizada = this,
    // de tal forma, QUE SE BLOQUEARÁN EL RESTO DE MÉTODOS QUE HAGAN
    // USO DE DICHA LLAVE. Así, si un hilo está escribiendo, el otro
    // no podrá ni escribir ni tampoco leer, ya que ambos usan la 
    // misma llave this.
    public synchronized void escribir() {
        System.out.println("ESCRIBIENDO EN EL CUADERNO");
        try {
            System.out.println("... retardo de 4 segundos ...\n");
            Thread.sleep(4000);
        } catch(InterruptedException ie) {}
    }

    // sincronización a nivel de método. LLave utilizada = this.    
    public synchronized void leer() {
        System.out.println("LEYENDO DEL CUADERNO");
        try {
            System.out.println("... retardo de 4 segundos ...\n");            
            Thread.sleep(4000);
        } catch(InterruptedException ie) {}
    }   

}