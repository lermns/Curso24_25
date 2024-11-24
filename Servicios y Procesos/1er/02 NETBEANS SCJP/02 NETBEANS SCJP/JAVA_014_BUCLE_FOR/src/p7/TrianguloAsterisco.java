// Crear una clase que mediante el uso de bucles for convencionales y anidados presente por
// pantalla las figuras mostradas a continuación. Utilizar incrementación y decrementación.

// *
// **
// ***
// ****
// *****        


// *****
// ****
// ***
// **
// *


package p7;

public class TrianguloAsterisco {
    
    public static void main(String[] args) {
        /*
        i=3
        j=4
        
        
        
        ->*
        ->* * 
        ->* * * 
        ->* * * *
        ->* * * * *
        
        
        
        
        */

        int cuantasFilas = 5;
                
        for (int i = 1; i <= cuantasFilas; i++) { // el número de * coincide con el índice de fila.
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // no hacer salto de línea.
            }
            System.out.println("");
        }
 
        
        System.out.println("\n");
        
        
        for (int i = cuantasFilas; i > 0; i--) { // igual pero con decrementador.
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }     
        
        
       
        
    }
}