// Crear una clase que genere una matriz de M*N filas/columnas. El contenido de la misma serán los
// números comprendidos entre el 1 y el producto de M*N, colocados aleatoriamente. Se requiere que
// el programa sea capaz de colocar en orden ascendente dicha matriz (array 2D).

// Una forma sencilla de realizar el código es crear sub-arrays para cada una de las filas de la matriz
// y unirlos todos, de forma secuencial, en un único array de 1 dimensión y de longitud M*N (un vector),
// para a continuación ordenar el mismo. Una vez ordenado, se procede a construir a partir de dicho
// array 1D, la matriz, cortando el array en trozos correspondientes al valor de N (columnas) lo que 
// vuelve a generar sub-arrays que nuevamente colocaremos de forma secuencia en la matriz, quedando esta
// ya ordenada. Crear distintos métodos (estáticos) que se encarguen de realizar dichas operaciones en lugar
// de uno sólo genérico (código espeso, complejo y poco reutilizable).


package p0;

public class Ordenacion2D {    
       
    public static int[] generarArray1D(int filas, int columnas) {
    
        // Generar elementos no repetidos como array 1D ... cuantos = filas*columnas.
        // Colocamos las filas unas a continuación de otras en un mismo array:
        int cuantos = filas * columnas;
        int[] array = new int[cuantos];
        
        bucleExterno:
        for (int i = 0; i < array.length; /*NADA*/) {
            
            int aleatorio = (int)(Math.random()*cuantos) + 1;           
            
            for (int j = 0; j < i; j++) {
                if(aleatorio == array[j]) {
                    continue bucleExterno; // continua el bucle externo.
                }                
            }
            
            array[i] = aleatorio;
            i++;
        }
        
        return array;        
    }
    
////////////////////////////////////////////////////////////////////////////////        
        
    public static int[] ordenar1D(int[] numeros) {   
        
        boolean hayCambio;
        
        do {
            hayCambio = false;
            for (int i = 0; i < numeros.length-1; i++) {
                if(numeros[i]>numeros[i+1]) {
                    int temporal = numeros[i+1];
                    numeros[i+1] = numeros[i];
                    numeros[i] = temporal;
                    hayCambio = true;                    
                }
            }
        } while(hayCambio);
    
        return numeros;        
    }    
    
////////////////////////////////////////////////////////////////////////////////    
    
    public static void imprimir1D(int[] numeros) {
        for(int numero : numeros) {
            System.out.print(numero + "\t");            
        } 
        System.out.println("");
    }
        
////////////////////////////////////////////////////////////////////////////////        
    
    public static void imprimir2D(int[][] numeros) {
        for(int[] fila : numeros) {
            for(int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println("");
        } 
    }    
    
////////////////////////////////////////////////////////////////////////////////    
    
    public static int[][] generarMatriz(int[] numeros, int cuantasFilas, int cuantasColumnas) {
        
        int[][] matriz = new int[cuantasFilas][cuantasColumnas];
        
        int indice = 0;
        
        for (int i = 0; i < cuantasFilas; i++) {
            for (int j = 0; j < cuantasColumnas; j++) {
                matriz[i][j] = numeros[indice++];
            }            
        }
        
        return matriz;        
    }
    
////////////////////////////////////////////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////        
    
    public static void main(String[] args) {
        
        // ELEGIREMOS AQUÍ LAS DIMENSIONES DE LA MATRIZ (FILAS (M) //  COLUMNAS (N)):
        final int filas = 4;
        final int columnas = 3;        
        
        int[] array = generarArray1D(filas, columnas);

        System.out.println("\n_____________ARRAY 1D SIN ORDENAR____________\n");        
        
        imprimir1D(array);
        
        System.out.println("\n_____________MATRIZ SIN ORDENAR____________\n");
        
        int[][] matrizNoOrdenados = generarMatriz(array, filas, columnas);        
        imprimir2D(matrizNoOrdenados);
        
        System.out.println("\n_____________ARRAY 1D ORDENADO____________\n");        
        
        array = ordenar1D(array);
        imprimir1D(array);
        
        System.out.println("\n_____________MATRIZ ORDENADA____________\n");
        
        int[][] matrizOrdenados = generarMatriz(array, filas, columnas);
        imprimir2D(matrizOrdenados);
    }
}