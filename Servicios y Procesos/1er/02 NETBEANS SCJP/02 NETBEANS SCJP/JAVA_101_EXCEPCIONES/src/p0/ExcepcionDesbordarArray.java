// Crear una clase que demuestre, a través del desbordamiento de un array, cómo
// se produce la generación de una excepción de tipo NO comprobativo como es
// en este caso ArrayIndexOutOfBoundsException. Capturar dicha excepción e imprimir
// la pila de la misma mediante el método printStackTrace. Utilizar el metodo getMessage
// para obtener la información sobre el mensaje encerrado en el objeto capturado y hacer
// uso del método toSring. Observar cómo el compilador en ningún momento nos obliga a la
// gestión de la excepción por el hecho de ser de tipo NO comprobativo (no gestionada). 

// Nota: Una excepción es un objeto de una determinada clase, que hereda de la
// clase madre Throwable (lanzable). Es la forma en la que Java trata los errores
// en tiempo de ejecución. Como objetos que son, heredan de Object y disponen de
// una serie de método y atributos. Se pueden clasificar en comprovativas (checked)
// y no comprovativas(non checked). Las de tipo comprovativo requieren que el 
// código del programador, gestione la posible excepción, bien sea capturándola,
// lanzándola fuera del método o capturándola y lanzándola, normalmente como otro
// tipo. Las dos grandes subfamilias que parten del nodo principal Throwable son,
// Error y Exception.


// Nota: el texto en negro del flujo out es distinto del flujo err (error) que se verá
// en rojo. La consola puede mezclar indiscriminadamente ambos textos sin un orden 
// determinado.


package p0;

public class ExcepcionDesbordarArray {

    public static void main(String[] args) {
        
        int[] arrayNumeros = {0,1,2,3};
        
        for (int n : arrayNumeros) {
            System.out.print(n + " ");
        }
        
        System.out.println("\n_____________________\n");
        
        try {
            for (int i = 0; i < 5; i++) { // array de 4 elementos, no 5. Desbordamiento.
                System.out.print(arrayNumeros[i] + " ");
            }
        } catch(ArrayIndexOutOfBoundsException a) {
            System.out.println("");
            
            // TOSTRING DICE: FQN de la excepción + 4.
            System.out.println(a);
            
            System.out.println("\n_________________\n");
            
            // MESSAGE DICE: 4
            System.out.println("MESSAGE = " + a.getMessage());
            
            System.out.println("\n_________________\n");            
            
            // TRAZA DE LA PILA.
            a.printStackTrace();
            
            System.out.println("\n_________________\n");
            
            System.out.println("NO DEBERIAS CAPTURAR ESTA EXCEPCION");
        }

        // ARREGLARLO ... MODIFICA TU CÓDIGO, NO LA CAPTURES.        
        //        for (int i = 0; i < arrayNumeros.length; i++) {
        //            System.out.print(arrayNumeros[i] + " ");
        //        }    
    }    
}