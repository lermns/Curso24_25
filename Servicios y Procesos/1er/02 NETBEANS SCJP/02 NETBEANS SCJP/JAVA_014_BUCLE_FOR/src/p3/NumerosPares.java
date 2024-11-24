// Crear una clase que imprima los 25 primeros números pares, comenzando por el 0.
// Utilizar un bucle for convencional.


package p3;

public class NumerosPares {

    public static void main(String[] args) {

        for (int i=1; i<=25; i++) {
            
            if(i%2 == 0 ) {
                //veces+=1;
                System.out.println( i + " ... ES PAR, ELEMENTO: " + i);
            }else{
                System.out.println(i + " ... ES IMPAR, ELEMENTO: " + i);
            }
        }
        
        
        
        
        
        
    }
}