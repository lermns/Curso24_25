// Crear una clase que muestre el comportamiento de los operadores de bit sobre
// 2 números n1=7 y n2=15. 


package p5;

public class OperadoresBinarios {

    public static void main(String[] args) {
        
        int n1 = 7;
        int n2 = 15;
        
        System.out.println(n1 + " & " + n2 + " = " + (n1 & n2));    // AND.
        System.out.println(n1 + " | " + n2 + " = " + (n1 | n2));    // OR.     
        System.out.println(n1 + " ^ " + n2 + " = " + (n1 ^ n2));    // XOR.
        System.out.println("~" + n1  + " = " + ~n1);                // INVERSOR.        
        System.out.println("~" + n2  + " = " + ~n2);        
    }    
}