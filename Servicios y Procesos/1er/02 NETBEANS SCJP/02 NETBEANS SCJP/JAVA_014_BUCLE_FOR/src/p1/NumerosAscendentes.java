// Crear una clase que imprima por pantalla los números comprendidos entre 1 y 10, ambos incluídos y de
// forma ascendente, para finalmente indicar cuántos se han imprimido. Usar bucle for convencional.


package p1;

public class NumerosAscendentes {

    public static void main(String[] args) {
        
        int cuantos = 0;
        
        for(int x=1; x<=10; x++) {
            System.out.println("NUMERO ... " + x);
            cuantos++;
        }
        
        System.out.println("\nCUANTOS NUMEROS = " + cuantos);                
    }    
}