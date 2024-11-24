package Threads.CursoUdmy.Ejemplos.Runnable;

public class ViajeTarea implements Runnable{

    private final String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(i + " - " + nombre);
            try {
                Thread.sleep((long)(Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("finalmente me voy de viaje a " + nombre);
    }
}
