package Threads.EjemplosClase.ejemplo_1;

public class MiHiloRN implements Runnable{
    public static void main(String[] args) {
        Runnable run1 = new MiHiloRN();
        Runnable run2 = new MiHiloRN();
        Runnable run3 = new MiHiloRN();

        run1.run();
        run2.run();
        run3.run();
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
