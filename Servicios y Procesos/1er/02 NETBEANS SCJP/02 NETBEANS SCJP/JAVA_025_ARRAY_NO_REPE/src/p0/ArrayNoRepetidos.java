// Crear una clase que rellene un array de números enteros en el que no puede 
// darse ningún valor repetido. La longitud del array y por tanto el rango del
// número, se establece mediante el valor de una variable llamada "cuantos".
// Tras la ejecución el array debe contener todos y cada uno de los valores del
// rango, de forma desordenada y sin que se haya repetido ninguno de ellos.

package p0;

public class ArrayNoRepetidos {

    
    public static void imprimir(int[] numeros) {
        for(int numero : numeros) {
            System.out.print(numero + " ");
        } 
    }

    
    public static void main(String[] args) {
        
        final int cuantos = 12;
        
        int[] numeros = new int[cuantos];
        
        bucleExterno:
        for (int i = 0; i < cuantos; /*NADA*/) { // ir rellenando el array.
            
            int aleatorio = (int)(Math.random()*cuantos) + 1; // [1 .. cuantos].
            
            for (int j = 0; j < i; j++) { // revisar sólo las posiciones ya ocupadas.
                if(aleatorio == numeros[j]) {
                    continue bucleExterno; // continua el bucle externo (repetido, no añadir).
                }                
            }
            
            // llegados a este punto, el número no está repetido, añadirlo:
            numeros[i] = aleatorio;
            i++; // incrementar la posición a usar.
        }
        
        imprimir(numeros);
        System.out.println("\n---> cuantos numeros = " + numeros.length);

        
        
        System.out.println("\n\n--------- OTRA FORMA, utilizando break ----------\n");

        
        
        int[] numeros2 = new int[cuantos];
        
        for (int i = 0; i < cuantos; /*NADA*/) {
            
            int aleatorio = (int)(Math.random()*cuantos) + 1;
            
            boolean existe = false;
            for (int j = 0; j < i; j++) {
                if(aleatorio == numeros2[j]) {
                    existe = true;
                    break; // rompe el bucle interno.
                }                
            }
            
            if(!existe) { // si repetido, ni añado ni incremento la i.
                numeros2[i] = aleatorio;
                i++;
            }
        }
        
        imprimir(numeros2);
        System.out.println("\n---> cuantos numeros = " + numeros2.length);
        
        System.out.println("\n\n\nFIN DE IMPRESION");
    }
}