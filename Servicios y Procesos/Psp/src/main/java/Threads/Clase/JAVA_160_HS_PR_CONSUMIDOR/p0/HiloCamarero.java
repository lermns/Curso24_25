// Crear la clase HiloCamarero que recibirá como recurso compartido con el
// hilo cliente un determinado objeto de la clase Vaso. Se sobrescribe su
// método run para ir llenándole el vaso al cliente, esperando a que éste se
// lo beba para volvérselo a llenar, así, por un total de 3 veces.

// Nota: La forma en la que el hilo cliente indica que ya se ha bebido el
// vaso es mediante una invocación al método notify del objeto recurso
// compartido. Así NOTIFICA, AVISA al planificador (Scheduler) que ya ha
// terminado de usar dicho recurso compartido con lo que quedará libre para
// el siguiente hilo que entre en ejecución y lo solicite.

// Los hilos cliente y camarero no "hablan" directamente entre sí, sino con que
// lo hacen con el planificador, de forma indirecta a través del recurso
// compartido que es Vaso, ya que es sobre este elemento y SIEMPRE DENTRO DE UN
// CONTEXTO SINCRONIZADO (si no al ejecutar se generará una excepción) dónde se
// van a llamar los métodos wait(puede lanzar InterruptedException), notify y
// notifyAll.

// La diferencia entre notify y notifyAll se basa en que con el primero se le
// pide al planificador que "levante", que ponga en RUNNABLE (disponible, no
// confundir con RUNNING que equivale a en ejecución) UNO (no se puede elegir
// cuál, ya que eso lo decide el planificador) de los hilos que estuviesen
// esperando (estado WAITING) a poder utilizar el recurso compartido.
// En el caso de notifyAll lo que se pide es que se levanten TODOS y cada uno
// de los hilos que estaban esperando a poder usar el recurso compartido. Así,
// todos ellos pasan del estado de no ejecución (Waiting) al estado de disponible
// (Runnable) para poder ser candidatos a ejecución (Running) con lo que podrán
// llevar a cabo las tareas que tengan definidas en su método run.


// MUY IMPORTANTE:
// Si se trata de usar wait, notify o notifyAll fuera de un contexto 
// sincronizado (por método o bloque) o bien se invocan sobre algo
// que no sea el propio recurso compartido, se generará una excepción.

// EN EL USO DE LOS ANTERIORES MÉTODOS TODOS ELLOS HEREDADOS DE OBJECT,
// SE BASAN LAS APLICACIONES DENOMINADAS PRODUCTOR/CONSUMIDOR. En este
// tipo de aplicaciones hay 2 o más hilos trabajando sobre un mismo
// recurso, de forma que se coordinan en base a él, usándolo sólo cuándo
// el hilo que lo utilizó con anterioridad dió permiso para hacerlo.

// Ejemplos típicos como el actual son: Escritor-Lector, DarCera-PulirCera,
// Trabajar-Descansar ... dónde siempre vamos a encontrar ese mútuo acuerdo
// o coordinación a la hora de trabaja sobre algo que es utilizado por todos
// siguiendo la máxima de "ó lo usas tú ó lo uso yo, pero lo que no podemos
// hacer es usarlo los dos a la vez, así que mejor vamos a ponernos de acuerdo".


package Threads.Clase.JAVA_160_HS_PR_CONSUMIDOR.p0;


public class HiloCamarero extends Thread {

    // recurso compartido.
    private Vaso vaso;

    // constructor para cargar el recurso compartido.
    public HiloCamarero(Vaso vaso) {
        this.vaso = vaso;
    }

    // método run ... lo que debe hacer el hilo.
    @Override
    public void run() {

        // SINCRONIZACIÓN A NIVEL DE BLOQUE UTILIZANDO COMO LLAVE EL VASO.
        synchronized (vaso) {

            // hacerlo 3 veces.
            while (vaso.consultarVeces() <= 3) {
                // si el vaso está lleno, el camareno no debe volverlo a llenar,
                // luego se está quieto, se espera (waiting), e indica al planificador,
                // el Scheduler, que ya no necesita usar el recurso compartido:
                if (vaso.estaLLeno()) {
                    System.out.println("\nEL CAMARERO DICE QUE EL VASO ESTA LLENO");                    
                    vaso.notify(); // 1. invocar notify sobre vaso para avisar al planificador.
                    try {
                        vaso.wait(); // 2. invocar wait sobre vaso para entrar en estado de espera.
                                     // WAIT A DIFERENCIA DE SLEEP, SÍ SUELTA LA LLAVE.   
                                     // SE DEBE SIEMPRE NOTIFICAR PRIMERO Y HACER WAIT DESPUÉS.
                    } catch (InterruptedException ex) { // wait puede lanzar InterruptedException.
                        System.out.println(ex);
                    }
                } else {
                    // si el vaso está vacio:
                    System.out.println("\n>>>> " + vaso.consultarVeces() + 
                            " >>>> EL CAMARERO LLENA EL VASO ... PARA ALIVIAR LAS PENAS!!!");
                    vaso.llenarVaso(); // cambiar el estado de la propiedad lleno de vaso.
                    vaso.retardar(); // provocar un retardo sleep (no suelta la llave).
                    
                    // Sera el hilo cliente el que al vaciar el vaso incrementará el
                    // número de veces (podríamos haber elegido al camarero para hacerlo).
                }
            }
            
            System.out.println("\n>>>>>>>> EL CAMARERO LIMPIA, RECOGE TODO, APAGA LUCES Y CIERRA."
                                                + " FIN DEL HILO CAMARERO.");           
        }
    }
}