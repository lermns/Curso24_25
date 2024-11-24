// Crear una clase que herede de Thread y cómo la anterior, permita definir el
// nombre del hilo, estableciéndose su prioridad a NORMAL (ver más tarde qué 
// ocurriría si se coloca a MÍNIMA(nivel 1)). Sobrescribir su método run para
// que imprima por pantalla el nombre del presente hilo tanto al iniciarse como
// al finalizar la ejecución del mismo. Este hilo no solicita conmutación (yield).


package Threads.Clase.JAVA_154_HILOS.p5;


public class OtroHilo extends Thread {
    
    public OtroHilo(String nombre) {
        super(nombre);
        setName(nombre.toLowerCase());
        setPriority(6);
        //setPriority(MIN_PRIORITY);        
    }    
    
    @Override
    public void run () {        
        System.out.println("EJECUCION DEL HILO ... " + getName());        
        System.out.println("FINALIZACION DEL HILO ... " + getName());
    }    

}