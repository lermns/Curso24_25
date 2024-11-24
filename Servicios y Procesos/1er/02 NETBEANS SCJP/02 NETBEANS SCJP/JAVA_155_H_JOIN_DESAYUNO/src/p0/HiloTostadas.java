// Crear un hilo que se encargue de preparar las tostadas del desayuno. Mostrar
// mensajes por pantalla como una forma de emular el proceso. Generar un retardo
// de 3 segundos como tiempo necesario para preparar las tostadas.


package p0;


public class HiloTostadas extends Thread {

    @Override
    public void run() {
    
        System.out.println("PREPARO LAS TOSTADAS");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }        
        System.out.println("A LOS 3 SEGUNDOS ..... LAS TOSTADAS ESTAN LISTAS");
    }   

}