// Crear una clase que haga uso de la clase del sistema java.lang.Math, para generar
// 10 números enteros múltiplos de 5 que esten dentro del rango [-1 .. -100].


package p1;

public class NegativosMultiplos5 {

    public static void main(String[] args) {
        
        for (int i = 1; i <= 10;) {
            int numero = (int)(Math.random()* -100) - 1;
            
            if(numero % 5 == 0) {                
                System.out.println("numero_" + i + " ---> " + numero);
                i++;
            }
        }       
    }    
}