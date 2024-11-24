// Crear una clase que extienda a Thread y definir en ella un constructor para
// asignar el nombre al hilo y definir la prioridad del mismo como NORMAL(nivel 5).
// Sobrescribir su método run para que imprima por pantalla el nombre del hilo
// y solicite la conmutación a través del método yield(no lanza ninguna excepción).


package Threads.Clase.JAVA_154_HILOS.p5;


public class MiHilo extends Thread {
    
    public MiHilo(String nombre) {
        super(nombre);
        setPriority(NORM_PRIORITY);
    }
        
    @Override
    public void run () {        
        System.out.println("EJECUCION DEL HILO ... " + getName());
        System.out.println("SOLICITUD DE CONMUTACION POR PARTE DE ... " + getName());
        Thread.yield(); // solicitud de conmutacion a otro hilo de misma prioridad.
        System.out.println("FINALIZACION DEL HILO ... " + getName());
    }    

}