// Crear una clase Calculadora que efectúe las operaciones aritméticas básicas.

package p2;

public class CalculadoraBasica {

    public static void main(String[] args) {
        
        int n1 = 3;
        int n2 = 2;
        
        System.out.println(n1 + " + " + n2 + " = " + (n1+n2));
        System.out.println(n1 + " - " + n2 + " = " + (n1-n2));
        System.out.println(n1 + " * " + n2 + " = " + (n1*n2));
        System.out.println(n1 + " / " + n2 + " = " + (n1/n2));
        System.out.println(n1 + " % " + n2 + " = " + (n1%n2));
 
        System.out.println("\n_________________________\n");
    
        // EL SIGNO DEL RESTO LO MARCA EL PRIMER OPERNADO (DIVIDENDO)
        int x = -3;
        int y = -2;
        System.out.println(x + " % " + y + " = " + (x%y));    
    }    
}