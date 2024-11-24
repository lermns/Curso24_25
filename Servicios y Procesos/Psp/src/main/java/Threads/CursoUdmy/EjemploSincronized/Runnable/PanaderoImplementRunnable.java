package Threads.CursoUdmy.EjemploSincronized.Runnable;

import Threads.CursoUdmy.EjemploSincronized.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class PanaderoImplementRunnable implements Runnable{

    private Panaderia panaderia;

    public PanaderoImplementRunnable(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            panaderia.hornear("Pan n: " + (i+1));
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
