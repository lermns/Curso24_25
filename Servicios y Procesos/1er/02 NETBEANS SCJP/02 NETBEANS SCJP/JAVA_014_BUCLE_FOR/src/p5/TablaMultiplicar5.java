// Crear una clase que muestre por pantalla la tabla del 5. Usar un bucle for convencional.

package p5;

import java.util.Scanner;

public class TablaMultiplicar5 {

    public static void main(String[] args) {
        
        int tabla = 5;
        
        System.out.println("Introduce la tabla de multiplicar:");
        Scanner entrada = new Scanner(System.in);
        tabla = Integer.parseInt(entrada.nextLine());
        
        for (int indice = 1; indice <= 10; indice++) {
            System.out.println(indice + " * " + tabla + " = " + (indice*tabla));
        }        
    }    
}
