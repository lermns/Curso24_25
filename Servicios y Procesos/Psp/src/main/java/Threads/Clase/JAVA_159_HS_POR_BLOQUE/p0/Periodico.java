// Crear una clase Periodico que constituya el recurso compartido de la 
// aplicación. Se establece un atributo privado de tipo Object denominado
// "llave" que será usado como llave de sincronización a nivel de bloque.

// Nota: La sincronización a nivel de bloque se emplea para bloquear en
// multiacceso sólo una parte del código de un método, pudiéndose emplear
// cualquier tipo de objeto como llave de sincronización. También cabe la
// posibilidad de establecer la sincronización por bloque justo en el 
// inicio del método, lo que equivaldría a una sincronización a nivel de
// método pero, pudiéndose usar cualquier llave y no sólo la correspondiente
// al this que representa el objeto, algo que por supesto también es válido,
// De usarse this para el bloque sincronizado, se podrán bloquear todos los
// métodos síncronos de la clase.


package Threads.Clase.JAVA_159_HS_POR_BLOQUE.p0;

public class Periodico {

    // llave a utilizar puede ser cualquier objeto.    
    private Object llave; 
    
    // se carga la llave a través del constructor.
    public Periodico(Object llave) {
        this.llave = llave;
    }
    
    // método de retardo interno (reutilizar).
    private void retardar() {
        try{
            Thread.sleep(3000);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }    
    
    public void leerPeriodico() {
        
        // el método en su totalidad NO ESTÁ SINCRONIZADO. De hecho, cualquier hilo
        // en ejecución obtendrá un acceso inmediato a él, por lo menos a ésta primera
        // parte, en la que se visualizará por pantalla el mensaje "... NOTICIAS".
        String nombreHilo = Thread.currentThread().getName();
        
        System.out.println(nombreHilo + " ... ESTA LEYENDO LA SECCION DE NOTICIAS");
        retardar(); // CONMUTACIÓN POR SLEEP ... NO SE DEVUELVE LA LLAVE.
     
        // Es al llegar a este punto cuando nos encontramos con la sincronización
        // a nivel de bloque, que exige del actual hilo en ejecución, QUE ESTÉ EN
        // POSESIÓN DE LA LLAVE DE ACCESO para poder ejecutarlo y por tanto,
        // continuar con su flujo de ejecución. De no ser así, deberá esperar a
        // conseguir dicha llave, introduciéndose en un ESTADO DE NO EJECUCIÓN
        // de tipo BLOCKED (NON RUNNING STATES = BLOCKED, WAITING, SLEEPING).
        
        synchronized(llave) {
            // Sólo el hilo que posea la llave podrá ejecutar el contenido de este 
            // bloque, mostrándose por pantalla el mensaje "... DEPORTES".
            System.out.println(nombreHilo + " ... ESTA LEYENDO LA SECCION DE DEPORTES");
            // SE LE QUITARÁ LA LLAVE AL HILO AL FINALIZAR EL PRESENTE BLOQUE Y NO ANTES.
            retardar(); 
            System.out.println("\n   >> >> >> EL HILO " + nombreHilo +
                    " >> >> >> SUELTA LA LLAVE DEL BLOQUE DEPORTES \n");
        }
        
        // LLEGADOS A ESTE PUNTO ...
        
        // ... y una vez completado el bloque sincronizado, EL SCHEDULER LE QUITA
        // LA LLAVE AL HILO ACTUAL PARA PONERLA A DISPOSICIÓN DEL SIGUIENTE HILO
        // QUE LA SOLICITE. Podemos decir que "es el hilo el que suelta la llave",
        // pero en realidad, el único que tiene autoridad y control sobre todo el
        // proceso es EL PLANIFICADOR, EL SCHEDULER, de forma que es él quién "la
        // da y la quita". Si más tarde aparece otro bloque sincronizado o se llama
        // a un método igualmente sincronizado, SE DEBERÁ VOLVER A PEDIR LA LLAVE.
        
        // Si no se ha superado (ejecutado) el bloque anterior, el siguiente código
        // no se alcanzará (no hay saltos, LA EJECUCIÓN ES SIEMPRE LINEAL).
        // Se mostrará finalmente el mensaje "... PUBLICIDAD". Una vez hecho ésto,
        // al no requerirse ninguna llave, el acceso es inmediato.
        System.out.println(nombreHilo + " ... ESTA LEYENDO LA SECCION DE PUBLICIDAD");
    }
    
}