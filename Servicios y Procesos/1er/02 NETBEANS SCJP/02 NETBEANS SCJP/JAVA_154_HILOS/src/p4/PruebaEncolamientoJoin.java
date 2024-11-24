// Crear una clase que ponga de manifiesto el "encolamiento" de hilos a través
// del método join (puede lanzar InterruptedException) con respecto al hilo
// constituido a través del método main. Comprobar cómo si se encola un hilo/s
// a la ejecución de otro, éste último no puede terminar (salvo que se le de
// un tiempo máximo) hasta que no finalicen todos y cada uno de los hilos que
// tenga asociados por encolamiento.


package p4;


public class PruebaEncolamientoJoin {

    
    public static void main(String[] args)  {

        // La ejecución del método main GENERA un hilo.
        System.out.println("INICIO DE MAIN");
        
        MiHilo h1 = new MiHilo();       
        
        // arrancará y se parará por el sleep interno. Al hacerlo entrará main.
        h1.start(); 
        
        try {
            h1.join(); // máximo tiempo de espera a que termine ... infinito.
            //h1.join(1000); // máxima espera ... 1 segundo = 1000 ms.
        } catch(InterruptedException ie) {
            System.out.println(ie);
        }
        
        System.out.println("FIN DE MAIN");        
    }

}