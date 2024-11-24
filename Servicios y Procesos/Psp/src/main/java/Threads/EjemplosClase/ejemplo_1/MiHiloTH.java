package Threads.EjemplosClase.ejemplo_1;

public class MiHiloTH extends Thread{
    public static void main(String[] args) {
        Thread h1 = new MiHiloTH();
        Thread h2 = new MiHiloTH();
        Thread h3 = new MiHiloTH();

        h1.start();
        h2.start();
        h3.start();
    }

    @Override
    public void run() {
        System.out.println("Soy el hilo " + Thread.currentThread().getName());
        System.out.println("me duermo");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Despierto y termino y soy " + Thread.currentThread().getName());
    }
}
