package Threads.EjemplosClase.ejemplo_4;

public class Hilo1 extends Thread {

    public Hilo1(String nombre) {
        super(nombre);
        setPriority(NORM_PRIORITY);
    }

    @Override
    public void run () {
        System.out.println("EJECUCION NORM_PRIO DEL HILO ... " + getName());
        System.out.println("SOLICITUD DE CONMUTACION POR PARTE DE ... " + getName());
        Thread.yield(); // solicitud de conmutacion a otro hilo de misma prioridad.
        System.out.println("FINALIZACION DEL HILO ... " + getName());
    }

}