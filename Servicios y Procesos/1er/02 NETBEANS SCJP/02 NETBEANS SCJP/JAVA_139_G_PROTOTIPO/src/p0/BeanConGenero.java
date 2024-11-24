// Modificar la clase Bean anterior para que permita el uso de cualquier tipo
// de dato y no sólo del valor primitivo int. Utilizar la marca de género <E>.


package p0;


public class BeanConGenero <E> { // marcar la clase con género <E> = cualquier cosa.
    
    private E dato; // el tipo del atributo es E (lo decidirá quién la use).
    
    public BeanConGenero(E dato) { // pide parámetro de tipo E
        this.dato = dato;
    }

    public E getDato() { // devuelve valor de tipo E
        return dato;
    }

    public void setDato(E dato) { // asignar valor de tipo E.
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "" + dato;
    }
    
    
    public static void main(String[] args) {
        
        // CUÁNDO NO SE ESPECIFICA GÉNERO Y LA CLASE ESTÁ CREADA EN BASE A ÉSTE, EL QUE SE
        // UTILIZARÁ POR DEFECTO ES Object.
        
        // Así, vemos cómo al no indicarse ningún género para la instancia, cuya clase se marcó
        // con el género <E> (cualquier cosa), podemos utilizar int(por autoboxing a Integer) o
        // String indistintamente, ya que el género efectivo empleado por el compilador es Object,
        // y tanto Integer como String lo son.
        
        // GÉNERO UTILIZADO: NINGUNO, luego el sistema hace un uso implícito de Object (cualquier cosa).
        BeanConGenero beanConGenero1 = new BeanConGenero(5); // se almacena un Integer.
        System.out.println("----> " + beanConGenero1.getDato());
        
        beanConGenero1.setDato("hola"); // se reutiliza la instancia ahora para almacenar un String
        System.out.println("----> " + beanConGenero1.getDato());
        
        
        System.out.println("\n______________________________\n");

        
        // GÉNERO UTILIZADO: Integer. La clase sólo podrá manejar Integer.
        BeanConGenero<Integer> beanConGenero2 = new BeanConGenero<Integer>(5); // correcto, es Integer.
        System.out.println("----> " + beanConGenero2.getDato());        
        //beanConGenero2.setDato("hola"); // error, sólo se admiten elementos Integer. String no lo es.

        
        System.out.println("\n______________________________\n");

        
        // GÉNERO UTILIZADO: String. La clase sólo podrá manejar String.
        BeanConGenero<String> beanConGenero3 = new BeanConGenero<String>("hola"); // correcto, es String.
        System.out.println("----> " + beanConGenero3.getDato());
        //beanConGenero3.setDato(5); // error, sólo se admiten elementos String. Integer no lo es.
        
        
        // Se comprueba por tanto, cómo UNA VEZ FIJADO EL GÉNERO DE LA CLASE a la hora de constituir una
        // determinada instancia, el compilador se asegura de que los elementos manejados por ella correspondan
        // al tipo asignado en la declaración del género (también son válidos los subtipos por la regla IS-A).
        
        // De no ser así, se genera un error en tiempo de compilación, lo cuál ahorraría el tiempo a la hora de
        // depurar el código en ejecución (permite prescindir del casting y previene errores de conversión de
        // tipo - ClassCastException).
    }

}