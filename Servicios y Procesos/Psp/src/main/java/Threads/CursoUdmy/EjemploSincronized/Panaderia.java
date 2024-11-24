package Threads.CursoUdmy.EjemploSincronized;

public class Panaderia {

    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa){
        while (disponible) {
            try {
                //  mantiene al hilo en espera hasta que este es llamado por notify para ver si
                //  puede recuperar el proceso, esto se da ya que son metodos syncronized
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.pan=masa;
        System.out.println("El pan se esta horneando: " + this.pan);
        this.disponible = true;
        //  avisa a los hilos en espera que este va a ser liberado más no de inmediato, lo liberara
        //  cuando este termine de usar el recurso, no se sabe a cual hilo se le va a dar el control
        //  esto es algo que el jvm maneja.
        notify();
    }

    public synchronized void consumirPan(){
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Cliente se come el pan: " + this.pan);
        this.disponible=false;
        notify();
    }
}
