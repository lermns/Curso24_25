package Threads.EjemplosClase.ejemplo_4;

public class Main {
    public static void main(String[] args) {
        Thread h1 = new Hilo1("hilo de norm prio");

        Thread[] hilosBja = new Hilo2[100];
        //asignar nombre a cada hilo
        for (int i = 0; i < 100; i++) {
            hilosBja[i] = new Hilo2("Hilo"+i);
        }


        Thread[] hilosAlt = new Hilo3[50];
        //asignar nombre a cada hilo
        for (int i = 0; i < 50; i++) {
            hilosAlt[i] = new Hilo3("Hilo"+i);
        }

        h1.start();

        for (int i = 0; i < 100; i++) {
            hilosBja[i].start();
            if (i<50){
                hilosAlt[i].start();
            }
        }
    }
}
