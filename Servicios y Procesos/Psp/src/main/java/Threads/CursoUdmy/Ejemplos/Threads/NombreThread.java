package Threads.CursoUdmy.Ejemplos.Threads;

public class NombreThread extends Thread{

    //  contructor para crear el hilo con un parametro que sera el nombre que le pondremos al hilo
    public NombreThread(String name) {
        super(name);
    }

    //  sobreesribimos el metodo run() que el hilo ejecutara de principio hasta el fin.
    @Override
    public void run() {
        System.out.println("Se inicia el metodo run del hilo " + getName());

        for(int i=0; i<10; i++){
            try {
                //  pone en estado de espera al hilo durante 10 milesimas de segundos
                //  en este tiempo el otro hilo aprovecha para ejecutarse y asi inter-
                //  calar al momento de mostrar los print sin seguir un orden especifico
                // ya que cada uno esta trabajando en un hilo distinto.
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName());
        }

        System.out.println("Fin del hilo " + getName());
    }
}
