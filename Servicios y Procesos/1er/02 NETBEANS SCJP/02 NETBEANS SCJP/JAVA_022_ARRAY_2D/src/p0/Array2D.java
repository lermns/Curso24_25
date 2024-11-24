// Crear una clase que muestre la diferencia entre utilizar arrays de 1 y 2 dimensiones.
// Recorrer los elementos de cada uno de ellos a través de bucles for y for-each.


package p0;

public class Array2D {

    public static void main(String[] args) {
        
        int[] numeros1D     = {1,2,3} ; // array de números
        
        int[][] numeros2D   = { {1,2} , {3,4} , {5,6} } ; // array de arrays, de números.
        // en los 2D, length me da la longitud de la primera dimensión, la del array contenedor.
        
        /////////////////////// 1D /////////////////////////////////////        
                            
        for (int i = 0; i < numeros1D.length; i++) { // recorrer los elementos con bucle for.
            System.out.print(numeros1D[i] + " ");
        }
        
        System.out.println("\n__________________________\n");        
        
        for(int numero : numeros1D) { // recorrer con for-each (más sencillo).
            System.out.print(numero + " ");        
        }
                
        /////////////////////// 2D ///////////////////////////////////////
        // Los subarrays no tienen porqué tener la misma longitud todos.//
        //////////////////////////////////////////////////////////////////
        
        System.out.println("\n__________________________\n");
        //int[][] numeros2D   = { 
                        //            {1,2} ,   numeros2D[0]
                          //          {3,4} ,   numeros2D[1]
                            //        {5,6}     numeros2D[2]
                              //  } ;
        for (int i = 0; i < numeros2D.length; i++) { // recorrer los elementos con bucle for.
            
            // ME DA LOS NÚMEROS CONTENIDOS EN CADA SUBARRAY, QUE OBTENEMOS CON numeros2D[i]:
            for (int j = 0; j < numeros2D[i].length; j++) { // longitud de cada subarray.
                if (numeros2D[i][j]==5){
                    System.out.print(i+", "+j + " "); // COLUMNAS: no hacer salto de línea
                }
                
                
                
                
            }
            
            System.out.println("");
        }

        System.out.println("\n__________________________\n");
        
        // recorrer con for-each (más sencillo).
        // Observar cómo lo que obtenemos son subarrays de tipo int[]:
        for(int[] numeros : numeros2D) {
            System.out.print("[ ");
            for(int numero : numeros) { // de ese subarray, sacar ahora sus elementos.
                if (numero==5){
                    System.out.print(numero + " "); // COLUMNAS: no hacer salto de línea
                }
            }
            System.out.print("]");
            System.out.println(""); // nueva FILA: hacer salto de línea.
        }
        
        System.out.println("");
    }
}