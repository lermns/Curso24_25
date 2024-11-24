// Crear una clase en la que vamos a disponer de un dado que utilizaremos para
// obtener números aleatorios entre 1 y 30 (ambos incluídos). El sistema comenzará
// a obtener valores que imprimirá por pantalla en líneas de 5 elementos (completados
// éstos, se produce un salto de línea y se repite el proceso). Si el valor actual
// está en la franja comprendida entre el 10 y el 20 no se imprimirá y si a su vez
// es el número 15, el programa terminará, indicándose en última instancia cuántos
// numeros se han impreso hasta ese momento.

// Utilizar un bucle while infinito controlado con sentencias break y continue.


package p0;

public class VerNumerosBreakContinue {

    public static void main(String[] args) {

        int dado = 0;
        int contadorLinea = 1;
        int cuantasTiradas = 0;

        while (true) {
            dado = (int) (Math.random() * 30) + 1; // [1..30] 

            if (dado >= 10 && dado <= 20) {
                if (dado == 15) {
                    break; // rompe el bucle while.
                } else {
                    continue; // continúa con el siguiente paso en el bucle while.
                }
            }

            System.out.print(dado + "\t"); // caracter de escape de tabulación.
            cuantasTiradas++;
                    
            if (contadorLinea++ == 5) {
                System.out.println("\n");
                contadorLinea = 1;
            }
        }

        System.out.println("\nCUANTAS TIRADAS = " + cuantasTiradas);
    }
}