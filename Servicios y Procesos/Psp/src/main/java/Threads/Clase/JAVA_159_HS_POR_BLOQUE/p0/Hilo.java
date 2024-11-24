// Crear una clase Hilo que extienda de Thread y a la que pasaremos el recurso
// compartido Periodico a través de su constructor. Sobrescribir el método run
// para que invoque al método leerPeriodico del dicho recurso compartido (dentro
// de su código hay una parte que está sincronizada a nivel de bloque).


package Threads.Clase.JAVA_159_HS_POR_BLOQUE.p0;


public class Hilo extends Thread {

    // el recurso compartido.
    private Periodico periodico;
    
    // el constructor para cargar el recurso compartido.
    public Hilo(Periodico periodico) {
        this.periodico = periodico;
    }
    
    @Override
    public void run() {
        periodico.leerPeriodico();
    }

}