package Threads.EjemplosClase.ejemplo_4;

public class Hilo2 extends Thread {

    public Hilo2(String nombre) {
        super(nombre);
        setPriority(MIN_PRIORITY);
    }

    @Override
    public void run () {
        System.out.println("EJECUCION MIN_PRIO DEL HILO ... " + getName());
    }

}