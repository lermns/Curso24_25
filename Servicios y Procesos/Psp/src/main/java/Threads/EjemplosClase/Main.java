package Threads.EjemplosClase;

public class Main {
    public static void main(String[] args) {
        Alumno alum1 = new Alumno("pepe");
        Ejercicio ejer1 = new Ejercicio(alum1);
        Ejercicio ejer2 = new Ejercicio(alum1);
        Ejercicio ejer3 = new Ejercicio(alum1);
        Ejercicio ejer4 = new Ejercicio(alum1);

        ejer1.start();
        ejer2.start();
        ejer3.start();
        ejer4.start();

        try {
            ejer1.join();
            ejer2.join();
            ejer3.join();
            ejer4.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------termina Main---------");
    }
}
