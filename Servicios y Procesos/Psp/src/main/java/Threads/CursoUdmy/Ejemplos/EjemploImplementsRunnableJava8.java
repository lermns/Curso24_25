package Threads.CursoUdmy.Ejemplos;

public class EjemploImplementsRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {
        //  obtenemos el hilo del main para ver el estado en cada ejecucion
        Thread main = Thread.currentThread();


        //  Otra forma usando instancias anónimas
        Runnable viaje = new Runnable() {
            @Override
            public void run() {

                for(int i=0; i<10; i++){
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("finalmente me voy de viaje a " + Thread.currentThread().getName());
            }
        };

        //  usando expresiones lambda aun más simplifado
        Runnable viajeLambda = () -> {
            for(int i=0; i<10; i++){
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long)(Math.random()*1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("finalmente me voy de viaje a " + Thread.currentThread().getName());
            //  nos muestra el estado del hilo principal que sera 'WAITING'.
            System.out.println("Estado del hilo main: " + main.getState());
        };


        Thread v1 = new Thread(viajeLambda, "SantaCruz");
        Thread v2 = new Thread(viajeLambda,"Cochabamba");
        Thread v3 = new Thread(viajeLambda,"La Paz");
        Thread v4 = new Thread(viajeLambda,"Oruro");

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        //  hacen que el hilo del main se espere a que los demas hilos acaben sus procesos
        //  antes de mostrarse
        v1.join();
        v2.join();
        v3.join();
        v4.join();

        System.out.println("Completado la ejecucion de los threads");
        System.out.println("Estado del hilo main : " + main.getState());
    }
}
