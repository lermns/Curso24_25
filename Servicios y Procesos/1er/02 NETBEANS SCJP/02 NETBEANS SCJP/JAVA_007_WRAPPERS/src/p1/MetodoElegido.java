// Crear una clase que demuestre qué método es elegido en primer lugar por la
// máquina virtual cuando se dispone de un conjunto de ellos válidos para el
// parámetro utilizado.

// MÉTODO ELEGIDO EN PRIMER LUGAR:

// primitivo exacto --> primitivo más cercano por exceso --> Wrapper exacto -->
// Number --> Object --> parámetros variables (éstos son siempre los últimos elegidos).

// No se llamará nunca al que disponga de un primitivo más pequeño ni al que
// disponga del Wrapper que no sea exactamente el suyo (requeriría de autopromoción
// seguida de autoboxing ... ilegal). // Si no hay método válido, error de compilación.

/**
 *
 */
package p1;

public class MetodoElegido {
 
    public static void metodo(byte x) {
        System.out.println("SE LLAMA A byte(x)");
    }
    
    public static void metodo(int x) {
        System.out.println("SE LLAMA A int(x)");
    }

    public static void metodo(long x) {
        System.out.println("SE LLAMA A long(x)");
    }
    
    public static void metodo(double x) {
        System.out.println("SE LLAMA A double(x)");
    }    
    
    public static void metodo(Integer x) {
        System.out.println("SE LLAMA A Integer(x)");
    }    

    public static void metodo(Double x) {
        System.out.println("SE LLAMA A Double(x)");
    }    
    
    public static void metodo(Number x) {
        System.out.println("SE LLAMA A Number(x)");
    }    
    
    public static void metodo(Object x) {
        System.out.println("SE LLAMA A Object(x)");
    }    
    
    public static void metodo(int ... x) {
        System.out.println("SE LLAMA A (int ...x)");
    }    

    
    public static void main(String[] args) {
        
        int x = 5;
        metodo(5); // Ir comentando los métodos ya probados para eliminarlos.
    }    
}