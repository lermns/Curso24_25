// Crear la clase Persona que implementa la interfaz Comparable. Se realizará
// la futura ordenación natural de los elementos de tipo Persona en base al
// atributo nombre disponible en dicha clase.

// Nota: A menudo lo más conveniente es utilizar el algoritmo ya implementado
//       en clases como String, Integer ... de cara a definir métodos como
//       hashCode, equals, compare o compareTo.


package p0;

// Observar cómo se ha marcado la interfaz Comparable con el género <Persona>.
// De esta forma, al insertar automáticamente el método compareTo, este mostrará
// como atributo de entrada un elemento Persona, en lugar del habitual Object.


public class Persona implements Comparable<Persona> {

    private String nombre;
    
    
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    
    @Override
    public int hashCode() {
        // Observar cómo con los TreeXXX ni el hashCode ni el equals se usarán.
        System.out.println("--------------> SE LLAMA AL METODO HASHCODE");
        return nombre.hashCode();        
    }
    
    
    @Override
    public boolean equals(Object objeto) {
        // Observar cómo con los TreeXXX ni el hashCode ni el equals se usarán.
        System.out.println("--------------> SE LLAMA AL METODO EQUALS");
        return nombre.equals( ((Persona)objeto).nombre );
    }
    
    
    @Override
    public int compareTo(Persona p) {
        // ESTE EL EL MÉTODO QUE REALMENTE SE LLAMA PARA REALIZAR LA ORDENACIÓN Y
        // PARA DETERMINAR SI UN ELEMENTO ESTÁ O NO REPETIDO (VER SI DA 0).
        System.out.println("SE LLAMA AL METODO COMPARETO");
        
        // UTILIZAMOS EL MÉTODO YA IMPLEMENTADO compareTo DE LA CLASE STRING.
        // Observar más abajo cuál es su implementación.
        
        System.out.println(nombre + "(this) <-> " + p.nombre + "(parametro entrada)");
        
        int valor = nombre.compareTo(p.nombre);        
        System.out.println("valor de compareTo = " + valor + "\n\n");
        
        return valor; // negativo, cero, positivo. Determinará si repetido o no.
    }
    
    
    @Override
    public String toString() {
        return nombre;
    }   
}


/* --- IMPLEMENTACIÓN DE compareTo EN LA CLASE STRING ---

    public int compareTo(String anotherString) {
        int len1 = count;
        int len2 = anotherString.count;
        int n = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;
        int i = offset;
        int j = anotherString.offset;

        if (i == j) {
            int k = i;
            int lim = n + i;
            while (k < lim) {
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
        } else {
            while (n-- != 0) {
                char c1 = v1[i++];
                char c2 = v2[j++];
                if (c1 != c2) {
                    return c1 - c2;
                }
            }
        }
        return len1 - len2;
    }

 */