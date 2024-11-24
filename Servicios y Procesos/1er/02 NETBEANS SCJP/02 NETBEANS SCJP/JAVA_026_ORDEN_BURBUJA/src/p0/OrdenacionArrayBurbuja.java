// Crear una clase que defina un array de números enteros y lo rellene con valores
// aleatorios no repetidos(una variable denominada "cuantos" establece el total de
// números a usar). A continuación, se ordenarán dichos elementos en orden creciente,
// (mediante el método "de la burbuja") de forma que empezando desde el principio del
// array, se compruebe si el elemento que sigue a uno dado es mayor al actual y en 
// caso de serlo, se intercambien el uno por el otro. Se repetirá el proceso hasta que
// el array queda completamente ordenado.

// Utilizar aquellas sentencias de control, bucles y elementos que se consideren necesarios.


package p0;

public class OrdenacionArrayBurbuja {

    public static void imprimir(int[] numeros) {
        for(int numero : numeros) {
            System.out.print(numero + " ");
        } 
    }
    
    public static void main(String[] args) {
        
        final int cuantos = 10; // ordenaremos un total de 10 elementos.
        
        int[] numeros = new int[cuantos];
        
        bucleExterno:
        for (int i = 0; i < cuantos; /*NADA*/) {
            
            int aleatorio = (int)(Math.random()*cuantos) + 1; // [1..10]
            
            for (int j = 0; j < i; j++) { // revisar sólo las posiciones ya rellenadas.
                if(aleatorio == numeros[j]) {
                    continue bucleExterno; // continua el bucle externo (elemento repetido).
                }                
            }
            
            numeros[i] = aleatorio; // elemento no repetido, añadirlo al array.
            i++;                    // los elementos estarán desordenados.
        }

        System.out.println("************* NUMEROS SIN ORDENAR **************");
        System.out.println("\n");        
        
        imprimir(numeros);
        System.out.println("\n---> cuantos numeros = " + cuantos);        

        System.out.println("\n");        
        System.out.println("************* NUMEROS ORDENADOS **************");
        System.out.println("\n");        
        
        boolean hayCambio;// se declara fuera por el tema del do-while, para poder hacer la comprobación
        
        int gasto = 0; // variable para comprobar el total de operaciones de ordenación.
        
        // NOTA: el último elemento no tiene ningún otro con el que compararse, luego
        // sólo deberemos revisar hasta el penúltimo o se generará una excepción del tipo
        // ArrayIndexOutOfBoundsException.
        
        do {
            hayCambio = false; // detectará que un elemento no está bien situado.
            for (int i = 0; i < numeros.length-1; i++) { // llegar al penúltimo elemento.
                gasto++;
                if(numeros[i]>numeros[i+1]) { // comparar el elemento actúal con el que le sigue.
//                    System.out.println("i = " + i);
//                    System.out.println("numeros[i] = " + numeros[i]);
//                    System.out.println("numeros[i+1] = " + numeros[i+1] + "\n");
                    int temporal = numeros[i+1];    // variable de guarda (no perdemos el dato).
                    numeros[i+1] = numeros[i];      // cambiar valor siguiente por actual.
                    numeros[i] = temporal;          // cambiar valor actual por siguiente.
                    hayCambio = true; 
                }
            }
        } while(hayCambio); // repetir mientras se hayan producido cambios (aún no ordenado).
        
        imprimir(numeros);
        System.out.println("\n---> cuantos numeros = " + numeros.length);
        
        System.out.println("\nGASTO = " + gasto);
        
        System.out.println("\nFIN DE IMPRESION");
    }
}