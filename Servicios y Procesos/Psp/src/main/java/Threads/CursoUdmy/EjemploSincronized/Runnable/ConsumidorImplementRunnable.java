package Threads.CursoUdmy.EjemploSincronized.Runnable;

import Threads.CursoUdmy.EjemploSincronized.Panaderia;

public class ConsumidorImplementRunnable implements Runnable{
    private Panaderia panaderia;

    public ConsumidorImplementRunnable(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            panaderia.consumirPan();
        }
    }
}
