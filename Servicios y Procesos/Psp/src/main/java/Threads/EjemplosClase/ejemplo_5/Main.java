package Threads.EjemplosClase.ejemplo_5;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Impresora imp = new Impresora();

        Thread p1 = new Persona("pepe", 30, imp);
        Thread p2 = new Persona("naa", 50, imp);
        Thread p3 = new Persona("juan", 80, imp);
        Thread p4 = new Persona("sofi", 10, imp);
        Thread p5 = new Persona("yor", 100, imp);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();

        System.out.println("termina main");
    }
}
