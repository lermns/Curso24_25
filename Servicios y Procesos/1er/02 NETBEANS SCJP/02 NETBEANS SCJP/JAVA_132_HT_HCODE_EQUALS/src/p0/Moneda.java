// Crear una clase Moneda con los atributos nombre, valor y pais. Sobrescribir los métodos
// hashcode (usando sólo el nombre) y equals (usando valor y pais).

// SOBRESCRITURA DE HASHCODE E EQUALS ... LOS HASHTABLE USAN HASHING.
// En primer lugar, se llama al hashCode del elemento que se quiere introducir.
// Si éste es distinto a los ya existentes, se añade dicho elemento a la colección 
// sin realizar más comprobaciones. Si por el contrario, el valor obtenido 
// resulta igual a alguno de los ya existentes, se llamará al método equals
// del elemento que queremos añadir para que se compare con los ya existentes en 
// la colección (los recibe como parámetro). En el momento que encuentre uno
// que al compararse con él de true, se terminan las comprobaciones sin procederse a
// añadirlo. Si por el contrario, después de revisar todos los elementos contenidos en
// la colección ninguno dió true, se procede a añadir el elemento a la misma, ya que
// finalmente se determina que no es igual a ninguno de los ya existentes.


package p0;


public class Moneda {
    
    private String nombre;
    private Integer valor;
    private String pais;
    
    public Moneda(String nombre, Integer valor, String pais) {
        this.nombre = nombre;
        this.valor  = valor;
        this.pais   = pais;
    }
    
    public String obtenerDescripcion() {
        return "[" + nombre + ", " + valor + ", " + pais + "]";
    }    
    
    // Para comparar las monedas del mapa, utilizamos el campo KEY, que 
    // contiene el objeto Moneda. En el value introducimos la descripción
    // del objeto.
    @Override
    public int hashCode() {
        
        // podemos utilizar un sólo atributo para el hashcode (nombre) ...
        int valor = nombre.hashCode();
        
        // ... o utilizar todo.
        //int valor = nombre.hashCode() + valor.hashCode() - pais.hashCode();
        
        System.out.println("SE HA LLAMADO AL HASHCODE DE " + nombre + " --> " + valor);
        return valor;
    }   

    // SOBRESCRITURA DE EQUALS
    @Override
    public boolean equals(Object objeto) {
                
        // Realizar Deep-Comparation.
        if(objeto instanceof Moneda) {
            
            Moneda moneda = (Moneda)objeto;
            
            System.out.println("SE LLAMA A EQUALS DE " + nombre + "(this) <-> " +
                    moneda.nombre + "(parametro)");    
            
            // buscamos que coincidan valor y pais. El nombre lo comprobamos por hashCode.
            // Sacar el valor de los wrappers Integer o compará direcciones, no su contenido.
            if(valor.intValue() == moneda.valor.intValue() && pais.equals(moneda.pais)) {   
                return true;
            }
        }
        
        return false; // NO REPETIDO ... AÑADIRLO.
    }    
    
    @Override
    public String toString() {
        return nombre; 
    }

}