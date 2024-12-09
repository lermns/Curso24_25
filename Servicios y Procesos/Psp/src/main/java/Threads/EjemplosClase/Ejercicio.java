package Threads.EjemplosClase;

public class Ejercicio extends Thread{
    private final Alumno alm;

    public Ejercicio( Alumno alumn) {
        this.alm = alumn;
    }

    @Override
    public void run() {
        synchronized (alm){
            System.out.println("Inicio del ejercicio " + Thread.currentThread().getName());
            int  numLineas =0;
            while (numLineas<100) {
                numLineas += (int)((Math.random()*30)+1);
                System.out.println("Trabajando en el ejercicio " + Thread.currentThread().getName() + " porcentaje " + numLineas);
                try {
                    System.out.println("dejo el ejercicio " + Thread.currentThread().getName());
                    alm.wait(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Fin del ejercicio " + Thread.currentThread().getName());
        }
    }
}
