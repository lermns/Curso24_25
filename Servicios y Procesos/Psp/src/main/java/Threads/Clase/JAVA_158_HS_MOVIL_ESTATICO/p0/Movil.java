// Crear el recurso compartido Movil el cuál definirá los métodos estáticos
// llamarUrgencias y llamarAmigos, los cuáles internamente generan un retardo
// de 4 segundos. Al ser los métodos síncronos también estáticos, la llave que
// se utilizará será la propia de la clase, existiendo tan sólo 1 por cada clase
// y aplicación. 

// Nota: No confundir la llave obtenida a partir de la clase (Class) con la
//       asociada a una determinada instancia (de las muchas que se pueden
//       crear) de dicha clase. En este último caso se hará uso de this.
//       Salvaguardando este detalle, el funcionamiento de la sincronización
//       se use "this" o "Class" es el mismo.


package Threads.Clase.JAVA_158_HS_MOVIL_ESTATICO.p0;

public class Movil {

    // MÉTODO ESTÁTICO Y SÍNCRONO. Llave utilizada Movil.class (sólo hay 1).
    public static synchronized void llamarUrgencias() {
        System.out.println("SE LLAMA AL TELEFONO DE URGENCIAS.");
        try {
            System.out.println("... retardo de 4 segundos ...\n\n");
            Thread.sleep(4000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        System.out.println("termina telefono urgencias");
    }

    // MÉTODO ESTÁTICO Y SÍNCRONO. Llave utilizada Movil.class (sólo hay 1).
    public static synchronized void llamarAmigos() {
        System.out.println("SE LLAMA A LOS AMIGOS.");
        try {
            System.out.println("... retardo de 4 segundos ...\n\n");
            Thread.sleep(4000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        System.out.println("termina telefono amigos");
    }
}