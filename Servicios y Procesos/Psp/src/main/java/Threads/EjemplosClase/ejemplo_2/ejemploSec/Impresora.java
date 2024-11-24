package Threads.EjemplosClase.ejemplo_2.ejemploSec;

public class Impresora {

    synchronized void imprimir(int num, String name){
        System.out.println("lineas de " + name + " total de lineas " + num);
        for (int i = 0; i < num; i++) {
            System.out.println(name + " -> " + (i+1));
        }
        System.out.println("termina proceso de " + name);
    }
}
