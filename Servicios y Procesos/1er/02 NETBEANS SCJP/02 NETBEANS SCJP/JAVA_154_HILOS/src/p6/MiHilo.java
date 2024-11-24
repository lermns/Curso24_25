// Crear una clase que extienda a Thread, sobrescribiendo el método run para
// indicar por pantalla que se inicia y termina la ejecución del hilo.


package p6;


public class MiHilo extends Thread {
      
    @Override
    public void run () {        
        System.out.println("\nINICIO EJECUCION");
        System.out.println("FIN DE EJECUCION\n");    
    }    

}