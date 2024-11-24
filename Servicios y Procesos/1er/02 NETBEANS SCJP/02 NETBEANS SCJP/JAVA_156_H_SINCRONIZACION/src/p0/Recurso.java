// Crear una clase que constituirá el recurso compartido a usar por múltiples
// hilos, puediéndo aparecer por tanto el problema de la sincronización. Se
// define el método 1 como de tipo sincronizado, requiriéndose por tanto la
// llave de acceso para poder utilizarlo. Se establece dentro de él un retardo
// de 4 segundos. Por otra parte, se define el método 2 como no sincronizado
// y se establece en su interior el mismo retardo de 4 segundos.


// Nota: Cuando un hilo se conmuta como consecuencia de hacer un sleep, dicho
//       hilo no "suelta" la llave o llaves de sincronización que puediera
//       tener. Por el contrario, el uso del método wait sí provoca la liberación
//       de la llave o cerrojo del recurso compartido. Es el SCHEDULER o también
//       llamado planificador, el que otorga o quita las llaves al hilo. De la
//       misma forma, los hilos no "hablan" entre sí, sino que es el Scheduler
//       el que se encarga de sincronizarlos entre si.


package p0;


public class Recurso {

    // MÉTODO SINCRONIZADO ... TIENE ASOCIADO UN LOCK (el propio objeto, this).
    synchronized public void metodo1() {
        System.out.println("\nINVOCACION - DEL METODO1 POR EL HILO ... " + 
                Thread.currentThread().getName());
            try {
                System.out.println("... retardo 4 segundos ...");
                Thread.sleep(4000); // retardo de 4 segundos.
            } catch(InterruptedException ie) {
                System.out.println(ie);
            }
        System.out.println("FINALIZACION - DEL METODO1 POR EL HILO ... " + 
                Thread.currentThread().getName() + "\n\n");
    }

    // MÉTODO NO SINCRONIZADO ... NO TIENE ASOCIADO UN LOCK.
    public void metodo2() {
        System.out.println("\nINVOCACION - DEL METODO2 POR EL HILO ... " + 
                Thread.currentThread().getName());
            try {
                System.out.println("... retardo 4 segundos ...");
                Thread.sleep(4000); // retardo de 4 segundos.
            } catch(InterruptedException ie) {
                System.out.println(ie);
            }
        System.out.println("FINALIZACION - DEL METODO2 POR EL HILO ... " + 
                Thread.currentThread().getName() + "\n\n");
    }       

}