// Crear una clase que herede de Thread y que reciba cómo parámetro el elemento
// que constituirá el recurso compartido. Sobrescribir el método run para invocar
// a los métodos m1 o m2 de dicho recurso, comprobando cómo el hecho de estar o
// no el mismo sincronizado, provoca que los hilos tengan que esperar a que el método
// invocado quede libre (el acceso requiere el estar en posesión del cerrojo, llave
// o lock de acceso), siempre y cuando trabajen sobre el mismo objeto o recurso.


package Threads.Clase.JAVA_156_H_SINCRONIZACION.p0;


public class Hilo extends Thread {

    private Recurso recurso;
    
    public Hilo(Recurso recurso) {
        // EL MISMO RECURSO PARA TODOS LOS HILOS.
        this.recurso = recurso;
        
        // UN RECURSO DISTINTO PARA CADA HILO.
        //this.recurso = new Recurso(); 
    }
        
    @Override
    public void run() {
        
        // Elegir uno de los 2 métodos y comprobar si hay o no esperas.
        
        //recurso.metodo1();      // sinchronized.
        recurso.metodo2();    // -nada-        
    }    

}