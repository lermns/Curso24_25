package Threads.EjemplosClase.ejemplo_2;

public class Persona extends Thread{
    private final int num;
    private final String name;

    public Persona(String name, int num) {
        this.name= "hilo"+name;
        this.num = num;
    }

    @Override
    public void run() {
        imprimir();
    }

    private void imprimir(){
        System.out.println("lineas de " + name + " total de lineas " + num);
        for (int i = 0; i < num; i++) {
            System.out.println(name + " -> " + (i+1));
        }
        System.out.println("termina proceso de " + name);
    }
}
