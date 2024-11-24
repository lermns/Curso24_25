// Crear una clase que genere 2 instancias de la anterior clase Hilo y los arranque.
// Observar cómo a la hora de intentar acceder al método 1 del recurso compartido,
// el segundo hilo que lo solicita deberá esperar a que el primero que lo hizo,
// termine completamente la ejecución de dicho método para conseguir acceso al mismo.
// Sin embargo, el acceso al método 2, que no se declaró como sincronizado, no 
// requiere planificación por parte del Scheduler y por tanto, ningún hilo deberá
// de esperar a obtener la llave de acceso, simplemente porque no la hay.

// Una vez comprobado el funcionamiento, generar 1 objeto Recurso para cada uno de
// los hilos y verificar cómo al NO HABER realmente un recurso compartido (un único
// objeto a usar por los 2 hilos) y a pesar de que el método 1 sigue siendo síncrono,
// ya no se produce espera por el segundo hilo al tratar de usarlo. Cada objeto
// recurso seguirá teniendo su llave de acceso para el método 1, que será entregada
// al hilo que lo solicite, pero dado que tenemos 1 objeto recurso por cada hilo no
// habrán éstos de "pelearse" por dichas llaves. El uso de la sincronización consume
// elevados recursos de la máquina y sólo debe ser usada si realmente se necesita.


package p0;


public class PruebaSincronizacion {

    public static void main(String[] args) {
        
        Recurso clase = new Recurso();

        // A través del constructor de la clase podremos entregarle el recurso 
        // compartido a los objetos que se generen de ella.
        Hilo h1 = new Hilo(clase);                
        Hilo h2 = new Hilo(clase);
        
        h1.start();
        h2.start();           
    }   

}