// Crear una clase que trate de importar de forma estática la variable valor de
// de las clases Valores1 y Valores2. Comprobar cómo el sistema muestra un error,
// indicando que la variable ya ha sido importada, al escribir el segundo import
// static (no sabe distinguir una de otra).


package p6;

import static p5.Valores1.valor;

// ERROR POR AMBIGÜEDAD.
//import static p5.Valores2.valor;

public class ErroresImportEstatica_1 {

    public static void main(String[] args) {
        
        System.out.println("el valor es ... " + valor);   
    }   
}