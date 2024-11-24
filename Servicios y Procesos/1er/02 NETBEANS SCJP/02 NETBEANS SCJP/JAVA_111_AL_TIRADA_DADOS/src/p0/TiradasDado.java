// Crear una clase que simule el lanzamiento de un dado de 10 valores [1..10].
// Cada tirada se irá introduciendo en una colección de tipo ArrayList y se 
// presentará por pantalla de modo que el valor obtenido represente la misma
// cantidad en dinero. Se define un número prohibido que provocará la terminación
// del programa, previa presentación del total de jugadas realizadas, el dinero
// conseguido como suma de todas ellas, así como el valor medio de las mismas.
// Utilizar un bucle for-each cuándo sea necesario recorrer los elementos de la
// colección.

// Nota. Es posible que se haga uso de la declaración eagerly para hacer más
// sencillo el programa. No obstante, la forma más elegante es instanciar el
// objeto en el constructor. Ésto es válido para el ejerccio actual cómo para
// el resto de los de tipo Colecciones.


package p0;

import java.util.ArrayList;

public class TiradasDado {

    public static void main(String[] args) {
        
        int numeroProhibido = 6;
        int dado = 0;
        ArrayList numeros = new ArrayList(); // declaración eagerly por sencillez.

        // valores [1..10]
        while( (dado = (int)(Math.random()*10 + 1)) != numeroProhibido ) {            
            System.out.println("HA SALIDO EL ... " + dado);
            numeros.add(dado);            
        }
        
        if(numeros.isEmpty()) {
            System.out.println("HA SALIDO EL NUMERO PROHIBIDO LA PRIMERA VEZ");
            System.exit(0);
        }
        
        System.out.println("\nNUMERO TOTAL DE JUGADAS VALIDAS ... " + numeros.size());
        
        int dineroTotal = 0;
        
        for (Object objeto : numeros) {
            dineroTotal += (Integer)objeto;
        }
        
        System.out.println("\nDINERO TOTAL ACUMULADO ... " + dineroTotal);
        
        System.out.println("\nMEDIA ACUMULADA POR TIRADA ... " + (dineroTotal/numeros.size()));
    }
}