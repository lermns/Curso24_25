// Crear la clase HiloCliente de la misma forma que se explico con el hilo
// del camarero, pèro prestando atención a la siguiente salvedad (de lo
// contrario nos encontraremos con que el programa no termina núnca):

// 1.   Partimos de que el vaso está vacio, por lo que independientemente
//      del hilo que entre primero en ejecución (start), será siempre el
//      camarero el que comience (si entra cliente, lo primero que hará
//      será un wait, dando paso como ya hemos dicho al camarero para que
//      llene el vaso).

// 2.   Es lógico pensar que si el camarero empieza, será el cliente el que
//      transcurridas las 3 veces termine. Así, SE DEBE AÑADIR EN EL HILO
//      CLIENTE, A CONTINUACIÓN DEL WHILE QUE CONTROLA ESAS 3 VECES, UN
//      NOTIFY QUE PERMITA AL HILO CAMARERO TERMINAR, YA QUE DE LO CONTRARIO
//      ESTE QUEDARÁ EN UNA ESPERA INFINITA. Según se ha planteado el ejercicio
//      es el hilo cliente el que incrementa el total de veces. Superado el 3
//      no hay forma de que el camarero salga del bucle while si no es a través
//      de esa notificación adicional, en la que se comprobará que veces es > 3
//      y por tanto la condición while(veces <= 3) ya no se cumplirá, finalizando
//      ambos hilos y por tanto el programa.

// De plantearse la solución de forma distinta, comprobar que no se entra
// en una situación de espera infinita. Todos los hilos en ejecución deben 
// terminar para que la aplicación (no confundirlo con el método main), pueda
// terminar.


package Threads.Clase.JAVA_160_HS_PR_CONSUMIDOR.p0;


public class HiloCliente extends Thread {

    // recurso compartido.
    private Vaso vaso;

    public HiloCliente(Vaso vaso) {
        this.vaso = vaso;
    }

    @Override
    public void run() {

        // Sincronizar en base al recurso compartido. De no utilizarse un contexto
        // sincrono o de utilizarse algo que no sea el recurso compartido, se 
        // producirá un error en ejecución.
        synchronized (vaso) {

            while (vaso.consultarVeces() <= 3) {
                if (!vaso.estaLLeno()) { // cuando el vaso está VACIO:
                    System.out.println("\nEL CLIENTE DICE QUE EL VASO ESTA VACIO");
                    vaso.notify(); // notificar al Scheduler que levante al hilo camarero.
                    try {
                        vaso.wait(); // el hilo cliente se pone en espera.
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                } else { // cuando el vaso está LLENO: 
                    System.out.println("\n>>>> " + vaso.consultarVeces() +
                            " >>>> EL CLIENTE SE BEBE EL VASO ... GLU-GLU-GLU .. HIP!!!");
                    vaso.vaciarVaso();
                    vaso.incrementarVeces(); // ES EL CLIENTE EL QUE INCREMENTA LAS VECES.
                    vaso.retardar();
                }
            }
            
            System.out.println("\n>>>>>>>> EL CLIENTE ESTA TROMPA, PAGA Y SE VA A CASA."
                                            + " FIN DEL HILO CLIENTE.");
            
            // NO OLVIDAR ESTE NOTIFY O EL CAMARERO NO TERMINARÁ.
            vaso.notify();
            
            // Probar no obstante a comentarlo para ver cómo el hilo camarero NO TERMINA NÚNCA.
        }
    }

}