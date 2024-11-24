package Threads.EjemplosClase.ejemplo_2.ejemploSec;

public class Persona extends Thread{
    private final int num;
    private final String name;
    private final Impresora imp;

    public Persona(String name, int num, Impresora imp) {
        this.name= "hilo"+name;
        this.num = num;
        this.imp = imp;
    }

    @Override
    public void run() {
        imp.imprimir(num, name);
    }

}
