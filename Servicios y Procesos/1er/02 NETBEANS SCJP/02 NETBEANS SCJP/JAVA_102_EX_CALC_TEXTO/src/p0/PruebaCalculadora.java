// Crear una clase que pruebe el funcionamiento de la calculadora de texto.
// Utilizar 1,2,"uno","dos",0, para ver cómo reacciona el sistema.


package p0;

import java.util.Scanner;

public class PruebaCalculadora {

    public static void main(String[] args) {

        try{    
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce el primer número>>>");
            String numero1 = sc.nextLine();
            System.out.println("a: "+numero1);

            System.out.println("Introduce el segundo número>>>");
            String numero2 = sc.nextLine();
            System.out.println("a: "+numero2);


//            CalculadoraTexto.sumar(numero1,numero2);
//            CalculadoraTexto.dividir(numero1,numero2);
            
            CalculaTex.sumar(numero1,numero2);
            CalculaTex.dividir(numero1,numero2);

            
            
            
            
            
            
         }catch(Exception e)    {
            e.printStackTrace();
         }
    }    
}