// Crear una clase que haga uso de las anteriores variables valor y altura. Para
// ello, utilizar la importación convención con la variable valor y la importación
// estática en el caso de altura (se comprueba como nos limitamos a colocar el
// nombre de la variable).

// Nota: la declaración es import static (no static import) y sólo sirve para
// elementos de tipo estático (puedo elegir un sólo elemento o todos a la vez
// mediante el uso del comodin *).


package p1;

import p0.Constantes;
import static p0.ConstantesImportEstatica.altura;


public class Usuario {

    public static void main(String[] args) {
        // Modos de utilizar valor ... importación o Fully Qualified Name (FQN).
        System.out.println("valor = " + p0.Constantes.valor);
        System.out.println("valor = " + Constantes.valor);
        
        System.out.println("\n-----------------------------------------\n");
        
        // Modos de utilizar altura ... personalmente sigo prefiriendo el FQN.
        System.out.println("altura = " + p0.ConstantesImportEstatica.altura);
        System.out.println("altura = " + altura);
    }   

}