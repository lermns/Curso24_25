// Crear una clase que muestre las distintas formas de crear un array unidimensional.


package p0;

public class DeclararInicializarArrays {

    public static void main(String[] args) {

        // new int[300000]; // error, el objeto no puede crearse sin referencia.        
        
        // es correcto para el compilador pero no adecuado (2 comas finales dará error):
        int[] raro = {0, 1, };
        
        // FORMAS DE DECLARAR UN ARRAY:
        
        int[] numerosA = {0, 1, 2, 3};
        
        for(int n : numerosA) {
            System.out.print(n + " ");
        }
                
        System.out.println("\n\n");        
        
        ////////////////////////////////////////////////
        
        int[] numerosB = new int[4];
        
        for(int n : numerosB) {
            System.out.print(n + " "); // elementos inicializados a 0.
        }

        System.out.println("\n\n");   

        numerosB[0] = 0; // ASIGNAR VALOR 1 x 1.
        numerosB[1] = 1;                
        numerosB[2] = 2;
        numerosB[3] = 3;
        
        for(int n : numerosB) {
            System.out.print(n + " ");
        }
        
        ////////////////////////////////////////////////        

        System.out.println("\n\n");  
        
        int[] numerosC;
        
        //numerosC = {0,1,2,3}; // error, esta asignación posterior no está permitida.
        
        numerosC = new int[]{0,1,2,3}; // esta sí.
        
        for(int n : numerosC) {
            System.out.print(n + " ");
        }
        
        System.out.println("\n\n");  

        ////////////////////////////////////////////////        
        
        int[] a, b, c, d; // 4 arrays de tipo int ... int[]
        
        int e[], f, g, h; // 1 array de tipo in ... int[], 3 variables primitivas int.
    }
}