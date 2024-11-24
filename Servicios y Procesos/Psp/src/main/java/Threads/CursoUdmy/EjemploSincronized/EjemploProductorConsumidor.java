package Threads.CursoUdmy.EjemploSincronized;

import Threads.CursoUdmy.EjemploSincronized.Runnable.ConsumidorImplementRunnable;
import Threads.CursoUdmy.EjemploSincronized.Runnable.PanaderoImplementRunnable;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();

        new Thread(new PanaderoImplementRunnable(panaderia)).start();
        new Thread(new ConsumidorImplementRunnable(panaderia)).start();
    }
}
