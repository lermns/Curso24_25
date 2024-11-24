// Crear una clase que imprima los números primos entre el 1 y el 99 haciéndo uso del
// bucle de control while.

package p1;

public class NumerosPrimosWhile {

    public static void main(String[] args) {

        int numeroMaximo = 99;

        int numero = 1; // el número a comprobar si es o no primo (se irá incrementando).

        while (numero <= numeroMaximo) {

            boolean dividido = false;
            int divisor = 2; // aquello por lo que vamos a ir dividiendo el número.

            while (divisor < numero) { // si se ha podido dividir no seguir.
                if (numero % divisor++ == 0) { // incrementar divisor hasta llegar a número.
                    dividido = true;
                    break;
                }
            }

           
            
            
            if (!dividido) { // si ninguna división, es primo.
                System.out.println("EL NUMERO ... " + numero + " ES PRIMO");
            }

            numero++;
        }
    }
}