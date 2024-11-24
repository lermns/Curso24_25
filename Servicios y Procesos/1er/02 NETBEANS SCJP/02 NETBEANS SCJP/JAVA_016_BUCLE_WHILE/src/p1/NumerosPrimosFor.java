// Crear una clase que imprima los números primos comprendidos entre 1 y 99 mediante
// el uso de un bucle for convencional (el siguiente ejercicio usará un bucle while).


package p1;

public class NumerosPrimosFor {

    public static void main(String[] args) {
        
        int numeroMaximo = 99;
                            
        for(int numero=1; numero<=numeroMaximo; numero++) {
            
            boolean dividido = false;  
            System.out.println("\nNUMERO = " + numero + "\n");
            
            for(int divisor=2; divisor<numero; divisor++) {
            
                //System.out.println("divisor = " + divisor);
                
                if(numero%divisor == 0) {
                    //System.out.println("---> DIVISION POR " + divisor + " RESULTA 0 ... NO PRIMO");
                    dividido = true;
                    break;
                }
            }
            
            if(!dividido) {
                System.out.println("EL NUMERO ... " + numero + " ES PRIMO");
            }
            
            //System.out.println("\n______________________________\n");            
        }        
    }   
}