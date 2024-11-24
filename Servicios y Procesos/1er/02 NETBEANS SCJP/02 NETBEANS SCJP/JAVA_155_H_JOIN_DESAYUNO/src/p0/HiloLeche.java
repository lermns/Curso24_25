// Crear un hilo que se encargue de calentar la leche para tomar el desayuno.
// Mostrar los correspondientes mensajes por pantalla empleando un retardo de
// 5 segundos como tiempo necesario para calentar la leche.


package p0;


public class HiloLeche extends Thread {

    @Override
    public void run() {
    
        System.out.println("CALIENTO LA LECHE EN EL CAZO");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }        
        System.out.println("A LOS 5 SEGUNDOS ..... LA LECHE ESTA LISTA");
    }   

}