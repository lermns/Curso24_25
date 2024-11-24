// Crear una clase que obtenga distintos números en el rango [-5 .. 0 .. +5] y 
// los separe en 2 conjuntos de tipo Set.


package p2;

import java.util.HashSet;

public class RangoSimetrico {

    public static void main(String[] args) {
        
        HashSet losPositivos = new HashSet();
        HashSet losNegativos = new HashSet();
                
        for (int i = 0; i < 20; i++) {
            
            int numero = (int)(Math.random()*10) + 1; // [1 .. 10]
            
            if(numero >5) {
                System.out.println("------> " + (numero - 5));
                losPositivos.add(numero - 5);                
            } else {                
                System.out.println("---> " + (numero - 6) ); // porque el mínimo es 1 [1..10]
                losNegativos.add(numero - 6);
            }            
        }
        
        System.out.println("\n_______________________________________________________\n");
        System.out.println(losPositivos);
        System.out.println("\n_______________________________________________________\n");        
        System.out.println(losNegativos);
        System.out.println("\n_______________________________________________________\n");        

        //////////////////////////////////////////////////////////////////
        
        int negativo = (int)(Math.random() * -5) -1; // [-1 .. -5]
        int positivo = (int)(Math.random() * 5) + 1; // [1 .. 5]

        System.out.println("\n................................................\n");
        System.out.println("un positivo = " + positivo);
        System.out.println("un negativo = " + negativo);
    }
}