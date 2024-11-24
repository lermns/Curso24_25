// Crear la clase Copistería para generar el recurso compartido Fotocopiadora, el
// cuál se entregará a los hilos cliente. Se crea una pareja de ambos, indicándo su
// nombre, el objeto Fotocopiadora y el número de fotocopias a realizar. Se arrancan
// los hilos y se observa cómo hasta que el primer cliente no ha terminado de realizar
// todas sus fotocopias, el otro no puede usar la máquina.

// Encolar ambos hilos con respecto a la ejecución del método main.


package p0;


public class Copisteria {

    // Lanzamos las excepciones fuera para centrarnos en cómo funciona el código.
    // Ya se ha indicado que esta técnica no es la adecuada, pero se busca el
    // tratar de comprender en la mayor medida posible los conceptos (no vamos
    // a pasar el ejemplo a producción).
    
    public static void main(String[] args) throws InterruptedException {

        // Crear el recurso compartido.
        Fotocopiadora fotocopiadora = new Fotocopiadora();
        
        // Crear los hilos entregándoles una referencia a dicho recurso compartido.
        Thread ana = new HiloPersona("ANA", fotocopiadora, 5);
        Thread juan = new HiloPersona("JUAN", fotocopiadora, 3);
        
        ana.start();
        juan.start();
        
        ana.join(); // encolar con respecto a main.
        juan.join();
        
        System.out.println("\n\nAMBAS PERSONAS HAN TERMINADO DE FOTOCOPIAR");        
    }

}