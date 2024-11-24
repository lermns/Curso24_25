// Crear una clase que genere la matriz traspuesta (aquella que cambia filas por columnas,
// siendo necesario que la original sea rectangular, no irregular), de una dada.


package p0;

public class MatrizTraspuesta {

    public static void main(String[] args) {
        
        int[][] matriz = { {1,2,3,4} , {5,6,7,8} }; // matriz fuente.
        
        int[][] traspuesta = new int[matriz[0].length][matriz.length]; // matriz traspuesta [FILAS][COLUMNAS].
        // Nº FILAS = matriz[0].length; // todas las filas miden lo mismo, luego usar cualquiera.
        // Nº COLUMNAS = matriz.length;
        // EN ESTE EJEMPLO [4][2] PARA LA TRASPUESTA.
        
        for (int i = 0; i < matriz.length; i++) { // número de subarrays en matriz fuente.
            for (int j = 0; j < matriz[i].length; j++) { // longitud de cada uno de los subarrays.
                traspuesta[j][i] = matriz[i][j]; // cambiar filas por columnas en la traspuesta.
            }
        }
                
        // IMPRIMIR MATRIZ FUENTE:
        for (int[] array : matriz) {
            for(int valor : array) {
                System.out.print(valor + " ");
            }
            System.out.println(""); // salto de fila.
        }
        
        System.out.println("\n_______________________\n");
        
        // IMPRIMIR MATRIZ TRASPUESTA:
        for (int[] array : traspuesta) {
            for(int valor : array) {
                System.out.print(valor + " ");
            }
            System.out.println("");
        }        
    }    
}