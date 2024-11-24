// Crear una clase que defina un array de enteros unidimensional de 25 elementos,
// y lo rellene con el valor de cada una las posiciones [0..24] .


package p1;

public class Numeros0_24 {

    public static void main(String[] args) {
        
        int[] arrayNumeros = new int[25];
        
        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = i;
            //System.out.print(arrayNumeros[i] + " ");
        }
        
        //System.out.println("\n_______________________________________\n");
        for (int i = 0; i < arrayNumeros.length; i++) {
            System.out.print(arrayNumeros[i] + " ");
        }
        System.out.println("----------------");
                
        for (int numero : arrayNumeros) {
            System.out.print(numero + " ");
        }
        
        System.out.println("");       
    }
}