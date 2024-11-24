package Threads.CursoUdmy.Ejemplos;

import Threads.CursoUdmy.Ejemplos.Threads.NombreThread;

public class EjemploExtendThread {
    public static void main(String[] args) {
        //  instancia de un hilo, asignandole el nombre a este.
        Thread hilo1 = new NombreThread("leo_hilo_1");
        Thread hilo2 = new NombreThread("Ian_hilo_2");
        Thread hilo3 = new NombreThread("Paty_hilo_3");

        //  metodo de theard, nos dice que este hilo se acaba de crear
        //  con la palabra 'NEW' en caso de que el hilo este corriendo
        // nos pondra 'RUNNABLE'
        System.out.println(hilo1.getState());

        //  metodo inicia el hilo, llama internamente a run()
        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println(hilo1.getState());
    }
}
