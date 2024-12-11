package Threads.EjemplosClase.ejemplo_5;

public class Persona extends Thread{
    private String name;
    private int num;
    private Impresora imp;

    public Persona(String name, int num, Impresora imp) {
        this.name = name;
        this.num = num;
        this.imp = imp;
    }

    @Override
    public void run() {
        imp.imprimir(num);
    }
}
