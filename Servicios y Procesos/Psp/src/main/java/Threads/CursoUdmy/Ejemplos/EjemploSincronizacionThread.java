package Threads.CursoUdmy.Ejemplos;

import Threads.CursoUdmy.Ejemplos.Runnable.ImprimirFrasesRunnable;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        Thread h1 = new Thread(new ImprimirFrasesRunnable("Hola ", "que tal!"));
        Thread h2 = new Thread(new ImprimirFrasesRunnable("¿Quien eres ", "tú?"));
        Thread h3 = new Thread(new ImprimirFrasesRunnable("Muchas ", "gracias amigo!"));

        h1.start();
        h2.start();
        h3.start();

        Thread.sleep(1000);
        //  nos muestra el estado de los hilos
        //  blocked - no puedo entrar al proceso
        //  terminated - termino el proceso
        //  timed_waiting - se encuentra esperando por el sleep
        //  runnable - que esta listo para ejecutarse o se esta ejecutando
        System.out.println("\nhilo1 -> " + h1.getState());
        System.out.println("\nhilo2 -> " + h2.getState());
        System.out.println("\nhilo3 -> " + h3.getState());
    }

    public synchronized static void imprimirFrases(String frase1, String frase2){
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(frase2 + " -> " + Thread.currentThread().getName() + " - "+Thread.currentThread().getState());
    }
}
