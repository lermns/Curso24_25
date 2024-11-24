// Crear una instancia de una clase que extienda a la clase Thread para a 
// continuación ejecutar su método start. Sobrescribir el método run en
// dicha clase hija de modo que se indique por pantalla un simple mensaje.


package p1;


public class MiHilo extends Thread  {

    // sobrescritura del método run de Thread, que NO hace nada, para que
    // realice la tarea que le indiquemos por código.
    @Override
    public void run() {
        System.out.println("SOY UN HILO DE EJECUCION USANDO HERENCIA DE THREAD");
    }

    public static void main(String[] args) {        
        Thread hilo = new MiHilo();
        hilo.start();        
    }

}