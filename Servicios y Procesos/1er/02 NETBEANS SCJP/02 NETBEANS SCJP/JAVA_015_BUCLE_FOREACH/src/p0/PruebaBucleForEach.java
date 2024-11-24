// Crear una clase que muestre por pantalla los números contenidos en un array. Utilizar el bucle
// for convencional y a continuación el for-each para ver las diferencias entre ambos.


package p0;

import java.util.ArrayList;

public class PruebaBucleForEach {

    public static void main(String[] args) {
        
        int[] numeros = {1, 2, 3};
        java.util.ArrayList numArr=new java.util.ArrayList();
        //java.util.ArrayList<? extends Object> numArr=new java.util.ArrayList<Integer>(); //Así sí funcionaría
        numArr.add(1);
        numArr.add(2);
        numArr.add(3);
        System.out.println(numeros);
        System.out.println(numArr);
        
        System.out.println("\n\n");
 
        // BUCLE FOR CONVENCIONAL (control de punto final manual):
        for (int indice = 0; indice < numeros.length; indice++) {
            System.out.print(numeros[indice] + "-- -- --");
        }
        
        System.out.println("\n________________________________\n");
        
        // BUCLE FOR-EACH (control del punto final automático):
        for(int n : numeros) {
            System.out.print(n + "  ");        
        }
        
        System.out.println("");
        
// ERROR ... NO PUEDE USARSE UNA VARIABLE EXTERNA, SÓLO LA INTERNA QUE SE DECLARE EN EL FOREACH.
//        int x = 0;
//        for(x : numeros) {}
    }
}