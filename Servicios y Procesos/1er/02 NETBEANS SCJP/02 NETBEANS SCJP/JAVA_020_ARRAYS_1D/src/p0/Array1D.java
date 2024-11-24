// Crear una clase que defina una array de números enteros y empleé los bucles for
// y for-each para mostrar sus elementos.


package p0;

public class Array1D {

    public static void main(String[] args) {
                     
        //int[] numeros = new int[300000];
        
        int[] numeros = new int[25];
        
        //numeros = new int[3];
        
        // los elementos se inicializan a su valor por defecto (el del tipo con el que
        // hubiesemos declarado el array).
        
        for (int i = 0; i < numeros.length; i++) { // recorrido con bucle for convencional.
            System.out.println("elemento en la posicion de indice "
                    + i + " = " + numeros[i]);
        }        
        
        System.out.println("\n\n");
        
        for(int numero : numeros) { // recorrido con bucle for-each.
            System.out.println(numero);
        }
    }    
}