package Threads.CursoUdmy.Ejemplos;

import Threads.CursoUdmy.Ejemplos.Runnable.ViajeTarea;

public class EjemploImplementsRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("SantaCruz")).start();
        new Thread(new ViajeTarea("Cochabamba")).start();
        new Thread(new ViajeTarea("La Paz")).start();
        new Thread(new ViajeTarea("Oruro")).start();
    }
}
