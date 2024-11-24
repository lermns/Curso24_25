// Crear una clase que utlice los operadores lógicos AND y OR, tanto en su versión
// "inteligente ... AND && ... no evalúa 2º operando si el primero es false"
// "inteligente ... OR || ... no evalúa 2º operando si el primero es true", como
// torpe (evalúa ambos operandos siempre).


package p3;

public class OperadoresLogicos {

    public static void main(String[] args) {
        
        boolean x = true;        
        boolean y = false;
        
        System.out.println(x + " & " + y + " = " + (x&y));
        System.out.println(x + " | " + y + " = " + (x|y));
        System.out.println(x + " !  = " + (!x));
        
        System.out.println("\n_____________________________________\n");
        
        System.out.println(x + " && " + y + " = " + (x&&y));
        System.out.println(x + " || " + y + " = " + (x||y));
  
  
        System.out.println("\n_____________________________________\n");
        
        // SI CON EL OPERADOR INTELIGENTE(LAZY OPERATOR) DE TIPO AND(&&) EL PRIMER OPERADOR ES FALSE,
        // EL SEGUNDO YA NO SE EVALÚA.
        
        int n1 = 10;
        int n2 = 20;
        
        if(n1>10 && ++n2>=20) {
            System.out.println("realizada comprobacion &&");
        }
        
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);

        
        
        System.out.println("\n_____________________________________\n");

        // SI CON EL OPERADOR INTELIGENTE(LAZY OPERATOR) DE TIPO OR(||) EL PRIMER OPERADOR ES TRUE,
        // EL SEGUNDO YA NO SE EVALÚA.
        
        int s1 = 10;
        int s2 = 20;
        
        if(s1>=10 || ++s2>=20) {       // true || true
            System.out.println("realizada comprobacion ||");
        }
        
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }    
}