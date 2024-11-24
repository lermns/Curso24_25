// Crear una clase que determine si un número introducido por teclado es o
// no capicua (se lee igual de izquierda a derecha que de derecha a izquierda).
// Para ello, hacer uso del método reverse de la clase StringBuilder y del
// método equals de la clase String (se compara por contenido).

// Ejemplos:
// 12345 ... NO es capicúa ... 54321.
// 2002  ... SÍ es capicúa ... 2002.


package p0;

import java.util.Scanner;

public class NumeroCapicua {

    public static void main(String[] args) {

        boolean repetir = true;
        String cadena = "";
        String cadenaInvertida = "";
        
        do {
            System.out.print("\nINTRODUCE UN NUMERO ENTERO >>> ");
            Scanner sc = new Scanner(System.in);
            cadena = sc.nextLine();

            try {
                Integer.parseInt(cadena);   // se hay excepción, se va al catch.
                repetir = false;            // si no hay excepción saldremos del bucle infinito.
            } catch (NumberFormatException nfe) {
                System.out.println("\nERROR, EL DATO INTRODUCIDO NO ES UN NUMERO");
            }
        } while (repetir);
        
        // Crear el StringBuilder para hacer uso de su método reverse (String no lo tiene).
        // El constructor admite de StringBuilder admite un String.
        StringBuilder inversor = new StringBuilder(cadena);
        
        // Una vez invertido, lo convertimos a un String tradicional.
        cadenaInvertida = inversor.reverse().toString();
        
        // Del nuevo String, utilizamos su equals para ver si son iguales (SB compara físicamente).
        if(cadena.equals(cadenaInvertida)) {
            System.out.println("\nEL NUMERO " + cadena + " SI ES CAPICUA");
        } else {
            System.out.println("\nEL NUMERO " + cadena + " NO ES CAPICUA");        
        }       
    }

}