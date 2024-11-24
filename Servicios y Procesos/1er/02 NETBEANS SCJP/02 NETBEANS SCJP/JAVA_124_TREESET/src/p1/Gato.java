// Crear la clase Gato con los atributos nombre y edad, de forma que las
// instancias de ésta pueden ser almacenadas en una colección de tipo árbol,
// concretamente en un TreeSet (debe implementar Comparable). Realizar la
// ordenación natural en base al nombre y si este resulta repetido, en base a
// la edad, en orden ascendente en ambos casos. Sobrescribir el método toString
// para informar sobre la instancia. Finalizado, intentar cambiar el mínimo
// código para que la ordenación resulte descendente.


package p1;


// Probar a quitar la implementación Comparable y observar el error en el TreeSet.
public class Gato implements Comparable {

    private String nombre;
    private int edad;
    
    public Gato(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public int compareTo(Object objeto) { 

        // Al no haberse utilizado género <Gato> con la interfaz, hay que hacer casting a Gato.
        // De quererse así, podríamos marcar primero y luego hacer insert code - Implements method,
        // con lo que el sistema nos daría el método compareTo con parámetro de entrada Gato, en
        // lugar de con Object, pudiéndonos olvidar por completo de tener que hacer el casting.
        
        // Sólo pueden compararse elementos del mismo tipo. Si además de gatos, existiese un elemento
        // Barco, el sistema generaría una excepción (tiempo de ejecución) al detectar que no puede
        // "colocar" ese elemento con respecto a los demás ... así, el uso del instanceof para forzar
        // un casting válido evitaría el problema de la mezcolanza de tipos y la consecuente excepción
        // (el compilador sólo detectará el error si usamos marca de <género>):
        
        //public class Gato implements Comparable<Gato> { ... }
        
        
        Gato g = (Gato)objeto; 
        
        // DECIDIMOS COMPARAR EN PRIMER LUGAR POR NOMBRE:
        if(!nombre.equals(g.nombre)) {          // comparar por nombre si son distintos.
            return nombre.compareTo(g.nombre);  // usar el compareTo de los String.
        }
        
        // Y EN SEGUNDO LUGAR, POR EDAD:
        return edad - g.edad;                   // y si nombres iguales, comparar por edad ascendente.        
                                                // restamos, lo cuál nos dara -, 0, +.
        
        //return g.edad - edad; // si se quiere en orden descendente, cambiar el lugar de los operadores.
    }  
    
    @Override
    public String toString() {
        return nombre + " ... " + edad + " años";
    }

}