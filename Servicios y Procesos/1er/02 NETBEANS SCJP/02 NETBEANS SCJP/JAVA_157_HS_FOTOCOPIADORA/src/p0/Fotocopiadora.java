// Crear la clase Fotocopiadora como recurso compartido a ser usado por diversos
// hilos. Se define un método sincronizado fotocopiar que pedirá como parámetro
// el número de fotocopias a realizar. Se mostrarán por pantalla una cadena de
// mensajes correspondiente cada uno de ellos a la fotocopia que se esté realizando,
// estableciéndose entre ellos un tiempo de retardo de 1 segundo. Se emplea el
// método sleep de la clase Thread y se comprueba como dicho método "no suelta la
// llave" del recurso compartido, lo que se traduce en que hasta que el cliente que
// empezó a fotocopiar no termine con todas y cada una de las fotocopias, el resto de
// clientes deberá esperar.


package p0;


public class Fotocopiadora {

    // probar a quitar synchronized de la declaración del método para ver
    // cómo varios hilos harían uso de la máquina a la vez.
    
    //public void fotocopiar(int cuantas) {                 // NO SINCRONIZADO.
    public synchronized void fotocopiar(int cuantas) {      // SÍ SINCRONIZADO.
        
        String nombre = Thread.currentThread().getName();
        
        for (int i = 1; i <= cuantas; i++) {
            System.out.println( nombre +", ESTA FOTOCOPIANDO LA HOJA NUMERO ... " + i);
            try {
                Thread.sleep(1000); // PROVOCA SLEEP DE EL HILO ACTUALMENTE EN EJECUCIÓN Y POR TANTO CONMUTACIÓN.
            } catch(InterruptedException ie) {
                System.out.println(ie);
            }
        }
        
        System.out.println(nombre + ", HA TERMINADO DE FOTOCOPIAR\n\n");   
    }   
    
}