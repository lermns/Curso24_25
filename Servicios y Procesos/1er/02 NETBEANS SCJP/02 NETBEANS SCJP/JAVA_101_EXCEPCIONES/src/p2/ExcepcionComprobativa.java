// Crear una clase en la que se invoque al método m1 que declara que puede
// lanzar excepciones del tipo comprobativo Exception. Dicha invocación se
// gestiona a través de un bloque try-catch preparado para capturar el
// citado tipo Exception. Si se produce la captura, se obtiene información
// del objeto a través del método getMessage y se utiliza ésta para constituir
// una nueva del tipo NumberFormatException (no comprobativa), para lo cúal
// se utilizar la versión del constructor que requiere un String.
// Observar como la excepción sale por el método main sin ser necesaria su 
// gestión, lo cual no quiere decir que no se vaya a corromper la apliación.

// Nota: con las comprobativas el compilador te obliga a gestionarlas (capturar,
// lanzar, capturar y lanzar). Con las NO comprobativas no hay obligación ... 
// pero asegurate de que tu programa funcione, no dejes cabos sueltos.


package p2;

public class ExcepcionComprobativa {
    
    private static void m1() throws Exception { // podría lanzar Exception
        System.out.println("EN M1");
        
        throw new Exception("SOY EXCEPTION ... "); // lanzarla a proposito.        
    }

    
    public static void main(String[] args) throws NumberFormatException {

        try {        
            m1(); // el throws obliga a que dicha posible excepción se gestione.
        } catch(Exception e) { // capturar tipo Exception y subtipos, regla IS-A.             
            // relanzarla como otro tipo (en este caso se elige No comprobativa).
            // se le añade el mensaje de la original más uno propio.
            throw new NumberFormatException(e.getMessage() +
                    " SOY NUMBER_FORMAT_EXCEPTION");
        }   
    }
}