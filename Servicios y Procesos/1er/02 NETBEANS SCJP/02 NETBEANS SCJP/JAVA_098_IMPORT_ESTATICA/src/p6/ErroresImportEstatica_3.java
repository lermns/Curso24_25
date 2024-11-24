// Crear una clase que realice la importación estática de la variable valor 
// correspondiente a las clases Valores1 y Valores2. En el caso de Valores1,
// se utilizará el comodin, mientras que para Valores2, se indicará directamente
// la variable valor. Comprobar cómo al tratar de usar dicha variable, se hace
// uso de la indicada por la importación directa (es prioritaria sobre la del *),
// de forma que no hay ambiguedad.


package p6;

import static p5.Valores1.*;
import static p5.Valores2.valor;

public class ErroresImportEstatica_3 {

    public static void main(String[] args) {
        
        System.out.println("el valor es ... " + valor);        
    }   
    
}