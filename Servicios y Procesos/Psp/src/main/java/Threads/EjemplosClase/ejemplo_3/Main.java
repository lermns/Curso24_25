package Threads.EjemplosClase.ejemplo_3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread h1 = new Coche(3);
        Thread h2 = new Coche(6);

        System.out.println("empieza main");

        h1.start();
        h2.start();
        h1.join();

        System.out.println("termina main");
    }
}
