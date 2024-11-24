// Crear una clase que genere y arranque la pareja de hilos para preparar las
// tostadas y calentar la leche. Establecer un encolamiento desde el método main
// con respecto a ellos para que éste no finalice hasta que el desayuno no éste 
// completamente listo.

package Threads.Clase.JAVA_155_H_JOIN_DESAYUNO.p0;

public class Desayuno {

    public static void main(String[] args) {
        
        System.out.println("\n---ME LEVANTO POR LA MAÑANA Y EMPIEZO "
                + "A PREPARAR EL DESAYUNO---\n");
        
        Thread hiloLeche = new HiloLeche();        
        Thread hiloTostadas = new HiloTostadas();
        
        hiloLeche.start();
        hiloTostadas.start();
        
        try {
            hiloLeche.join();
            hiloTostadas.join();
        } catch(InterruptedException ie) {
            System.out.println(ie.getMessage());
        }     
        
        System.out.println("\n---EL DESAYUNO ESTA LISTO, ME LO TOMO---\n");   
    }   

}