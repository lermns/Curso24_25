package Threads.EjemplosClase.ejemplo_4;

public class Hilo3 extends Thread {

    public Hilo3(String nombre) {
        super(nombre);
        setPriority(MAX_PRIORITY);
    }

    @Override
    public void run () {
        System.out.println("EJECUCION MAX_PRIO DEL HILO ... " + getName());
    }

}
