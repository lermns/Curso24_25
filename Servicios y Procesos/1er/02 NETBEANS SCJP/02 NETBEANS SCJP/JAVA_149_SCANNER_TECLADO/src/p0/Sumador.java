// Crear una clase que a través de un flujo Scanner solicite la introducción
// de 2 números enteros a través del teclado. Se realiza la conversión de
// texto a número, controlándose la posible excepción NumberFormatException 
// de modo que de producirse ésta, se vuelva a solicitar el dato. Finalmente
// se imprime el resultado por pantalla.

// Nota: Para la captura por teclado, usar nextLine(). El método next() es más
//       adecuado para tokenización. De usarse éste para el teclado, habremos
//       de vigilar que el sistema no se quede "colgado" esperando poder capturar
//       nuevos datos.


package p0;

import java.util.Scanner;


public class Sumador {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int contador = 0; // sólo pediremos 2 datos por teclado.
        String dato = null;
        int[] valores = new int[2]; // array para almacenar los datos convertidos a números.
        
        do { // se realiza al menos 1 petición de dato por teclado do-while.
            try {
                System.out.print("INTRODUCE EL DATO " + (contador+1) + " ---> ");
                dato = sc.nextLine(); // utilizar nextLine para capturar el teclado.
                valores[contador] = Integer.parseInt(dato); // convertir texto a número.
                contador++;
            } catch(NumberFormatException nfe) {
                System.out.println("ERROR EL DATO ... " + dato + " ES INCORRECTO \n");
            }            
        } while(contador<2); // pido 2 datos.

        System.out.println("VALORES QUE HAS INTRODUCIDO ...");

        for(int valor : valores) {
            System.out.print(valor + " ");
        }
        
        System.out.println("\n\nLA SUMA DE " + valores[0] + " CON " + valores[1] + " ES ..." +
                (valores[0] + valores[1]));       
    }

}