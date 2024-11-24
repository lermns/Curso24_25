// Crear una clase que genere un array de 2 dimensiones irregular, es decir, que
// las distintas filas que componen la matriz no tienen por qué tener el mismo
// número de elementos. Para ello, el sistema debe generar aleatoriamente tanto
// el número de filas (número total de sub-arrays) como el número de columnas
// (número total de elementos de cada sub-array) y rellenar la matriz (array 2D)
// generada.


package p1;

public class Array2DNumeroProgresivo {

    public static void main(String[] args) {
        
        // ARRAY 2D IRREGULAR.
        // *********
        // ***
        // ******
        // *        
                
        int cuantasFilas = (int)(Math.random()*10) + 1;  // [1..10]
        
        System.out.println("CUANTAS FILAS = " + cuantasFilas);
        
        // AL CREAR EL ARRAY 2D, HEMOS DE INDICAR POR LOS MENOS LA PRIMERA VARIABLE, ES DECIR,
        // AQUELLA QUE INDICA EL NÚMERO DE SUBARRAYS CONTENIDOS. LA SEGUNDA ES OPCIONAL, PERO
        // SI SE INDICA, OBTENDREMOS UNA MATRIZ ... TODOS LOS SUBARRAYS TENDRÁN LA MISMA LONGITUD.
        int[][] array2DIrregular = new int[cuantasFilas][]; // haz sitio para X sub-arrays.

        int valor = 0;

        for (int i = 0; i < array2DIrregular.length; i++) {            
            int cuantasColumnas = (int)(Math.random()*10) + 1;  // [1..10]            
            System.out.println("CUANTAS COLUMNAS PARA EL SUBARRAY_" + i + " ... " + cuantasColumnas);

            int[] columnas = new int[cuantasColumnas];
            // COLOCAMOS EL SUBARRAY DENTRO DE LA POSICIÓN i DEL ARRAY CONTENEDOR PRINCIPAL.            
            array2DIrregular[i] = columnas;
            
            // RELLENAMOS LOS ELEMENTOS DE CADA SUBARRAY EN ORDEN PROGRESIVO.
            for (int j = 0; j < columnas.length; j++) {
                columnas[j] = ++valor;
            }            
        }
        
        System.out.println("\n----------------- VISUALIZACION ----------------\n");
        
        // PRUEBA DE VISUALIZACIÓN 2D:
        //array2DIrregular = new int[][]{ {1,2} , {3,4,5,6,} , {7,8} };
        
        for(int[] fila : array2DIrregular) {
            for(int columna : fila) {
                System.out.print(columna + "\t");
            }
            System.out.println("");
        }   
    }    
}