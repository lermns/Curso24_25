// Crear una instancia de una clase que extienda a la clase Thread para a 
// continuación ejecutar su método start. Sobrescribir el método run en
// dicha clase hija de modo que se indique por pantalla un simple mensaje.

package Threads.Clase.JAVA_154_HILOS.p1;

public class MiHilo extends Thread  {

    public MiHilo(String ide){
        super(ide);
    }

    public MiHilo(){

    }

    // sobrescritura del método run de Thread, que NO hace nada, para que
    // realice la tarea que le indiquemos por código.
    @Override
    public void run() {
        System.out.println("SOY UN HILO DE EJECUCION USANDO HERENCIA DE THREAD: " + this.getName());
    }

    public static void main(String[] args) {        
        Thread hilo1 = new MiHilo("1");
        Thread hilo2 = new MiHilo("2");
        Thread hilo3 = new MiHilo();

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}