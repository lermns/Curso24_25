package Threads.Clase.JAVA_154_HILOS.p1;

public class MiHiloEjercicio extends Thread {

    public MiHiloEjercicio(String ide){
        super(ide);
    }
    public MiHiloEjercicio(){

    }

    // sobrescritura del método run de Thread, que NO hace nada, para que
    // realice la tarea que le indiquemos por código.
    @Override
    public void run() {
        System.out.println("SOY UN HILO DE EJECUCION USANDO HERENCIA DE THREAD: " + this.getName());
    }

    public static void main(String[] args) {
        Thread hilo;

        for (int i = 1; i <= 300; i++) {
            hilo = new MiHiloEjercicio(String.valueOf(i));
            hilo.start();
        }
    }
}
