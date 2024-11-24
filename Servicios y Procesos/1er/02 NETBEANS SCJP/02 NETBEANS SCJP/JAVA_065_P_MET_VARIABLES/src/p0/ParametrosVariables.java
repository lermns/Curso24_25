// Crear una clase que compruebe el funcionamiento de los parámetros finales en la
// declaración de un método y que haga uso de un bucle for-each para recorrer sus
// elementos. Verificar cómo el array interno se genera siempre, independientemente
// de que se envíen o no datos.


package p0;

public class ParametrosVariables {

    public void contadorNumeros(final int ... numeros) {
        
        System.out.println("¿EL ARRAY EXISTE? " + (numeros!=null?"SÍ":"NO") );
 
        System.out.println("hashcode del array = " + numeros.hashCode() + "\n\n");
        
        // numeros = null; // al usar final, no podemos desvincular la referencia. 
        
        // en el caso de no enviarse ningún dato, la longitud del array será de 0
        // elementos, pero dicho array SÍ existe, lo que NO provocará ningún error
        // al intentar ser recorrido por el bucle for-each:
        
        System.out.println("LONGITUD DEL ARRAY = " + numeros.length);
        
        for(int elNumero : numeros) {
            System.out.println("---> " + elNumero);
        }        
    }
    
    
    public static void main(String[] args) {

        new ParametrosVariables().contadorNumeros(); // objetos anónimos para pruebas.
        System.out.println("\n");
        new ParametrosVariables().contadorNumeros(8,2,27);
    }    

}