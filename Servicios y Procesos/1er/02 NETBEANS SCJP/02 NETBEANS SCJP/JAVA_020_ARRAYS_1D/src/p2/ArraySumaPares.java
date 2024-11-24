// Crear una clase que defina un arrayPares que contendrá los valores (2,4,6,8,10) y
// otro, arraySumatorio, cuyas elementos contendrán el sumatorio de los valores del
// arrayPares desde su inicio hasta la posición del elemento actual del arraySumatorio.


package p2;

public class ArraySumaPares {

    public static void main(String[] args) {
        
        int[] arrayPares = {2, 4, 6, 8, 10};
        
        int[] arraySumatorio = new int[arrayPares.length];  // [ 2, 6, 12, 20, 30 ]
        
        // posición del arraySumatorio.
        for (int i = 0; i < arraySumatorio.length; i++) {
            
            int suma = 0;
            
            // posiciones del arrayPares <= posición actual arraySumatorio.
            for (int j = 0; j <= i; j++) { 
                suma += arrayPares[j];
            }
            
            arraySumatorio[i] = suma;
            System.out.println(arraySumatorio[i]);
        }
    }
}