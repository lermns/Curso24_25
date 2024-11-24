// Crear una clase que calcule la suma y media aritmética, así como la detección del mínimo y máximo
// de los valores pasados a un método. Utilizar un línea de parámetros de entrada variables.


package p1;

public class OperacionParamVariables {

    // void ... declaramos que el presente método no devuelve nada (NO confundir con null).
    public static void calcular(double ... numeros) { 
    
        if(numeros.length <= 1) {
            System.out.println("INTRODUCE AL MENOS 2 NUMEROS");
            
            return;             // seguir con el main, sin ejecutar el cálculo y SIN PARAR EL PROGRAMA.
            //System.exit(0);   // PARAR DEFINITIVAMENTE EL PROGRAMA.
        }
        
        // lo que queremos obtener:
        double sumaAritmetica = 0;
        double mediaAritmetica = 0;
        double maximo = numeros[0];
        double minimo = numeros[0];
        
        // recorrer todos los elementos para obtener los resultados:
        for (double numero : numeros) {
            
            System.out.println("---> " + numero);
            sumaAritmetica += numero;
            
            if(numero < minimo) {
                minimo = numero;
            } else if(numero>maximo) {
                maximo = numero;
            }
        }
        
        mediaAritmetica = sumaAritmetica / numeros.length;
        
        System.out.println("SUMA ARITMETICA = " + sumaAritmetica);
        System.out.println("MEDIA ARITMETICA = " + mediaAritmetica);
        System.out.println("MAXIMO = " + maximo);
        System.out.println("MINIMO = " + minimo);
    }
    
    
    public static void main(String[] args) {
        calcular();     
        System.out.println("\n__________________\n");
        calcular(5,2,7,9);     
        System.out.println("\n__________________\n");
        calcular(9,-1);     
    }   
}