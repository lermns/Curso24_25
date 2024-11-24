// Crear una clase Bar que compruebe el funcionamiento del sistema productor
// consumidor entre el camarero el cliente y el recurso compartido vaso.


package Threads.Clase.JAVA_160_HS_PR_CONSUMIDOR.p0;


public class Bar {

    public static void main(String[] args) {
        
        // Creación del recurso compartido.
        Vaso vaso = new Vaso();
        
        // Creación de los hilos:
        
        // EL PRODUCTOR.
        HiloCamarero camarero = new HiloCamarero(vaso);
        
        // EL CONSUMIDOR.
        HiloCliente cliente = new HiloCliente(vaso);
        
        // Arranque de los hilos (no importa el orden).
        cliente.start();
        camarero.start();        
        
        // Encolamiento de ambos con respecto al main.
        try {
            cliente.join();
            camarero.join();
        } catch(InterruptedException ie) {
            System.out.println("ERROR DE ENCOLAMIENTO");
            ie.printStackTrace();
        }
                
        System.out.println("\n\n --- MAIN DICE QUE SE TERMINO --- \n");
    }    

}