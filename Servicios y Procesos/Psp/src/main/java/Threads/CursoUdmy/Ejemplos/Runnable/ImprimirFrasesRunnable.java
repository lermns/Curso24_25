package Threads.CursoUdmy.Ejemplos.Runnable;

import static Threads.CursoUdmy.Ejemplos.EjemploSincronizacionThread.imprimirFrases;

public class ImprimirFrasesRunnable implements Runnable{
    private final String frase1;
    private final String frase2;

    public ImprimirFrasesRunnable(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        imprimirFrases(this.frase1, this.frase2);
    }
}
