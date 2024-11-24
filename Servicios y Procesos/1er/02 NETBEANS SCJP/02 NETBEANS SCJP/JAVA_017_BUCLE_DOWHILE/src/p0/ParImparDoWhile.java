// Crear una clase que mediante el uso de un bucle do-while realice un número
// concreto de tiradas, utilizando un dado con un total de 100 valores
// posibles. Realizadas éstas, el programa deberá indicarnos cúantos elementos
// pares e impares se han obtenido y las sumas parciales de cada uno de ellos.


package p0;

public class ParImparDoWhile {

    public static void main(String[] args) {

        int cuantasTiradas = 0;
        int cuantosPares = 0;
        int cuantosImpares = 0;
        int sumaPares = 0;
        int sumaImpares = 0;

        int tirada = 0;

        do {
            tirada++; // incrementar el número actual de la tirada.
            int dado = (int) (Math.random() * 100) + 1; // [1 .. 100].

                // pares
                if(dado % 2 == 0) {
                    System.out.print("PAR ---> " + dado);
                    sumaPares += dado;
                    cuantosPares++;
                } else {
                // impares
                    System.out.print("IMPAR ---> " + dado);
                    sumaImpares += dado;
                    cuantosImpares++;
                }

            System.out.println("\n");

        } while (tirada < cuantasTiradas);

        System.out.println("\n------------------ RESULTADOS -------------------\n");
        
        System.out.println("CUANTOS PARES = " + cuantosPares);
        System.out.println("SUMA TOTAL PARES = " + sumaPares);
        System.out.println("\n");
        System.out.println("CUANTOS IMPARES = " + cuantosImpares);
        System.out.println("SUMA TOTAL IMPARES = " + sumaImpares);       
    }
}