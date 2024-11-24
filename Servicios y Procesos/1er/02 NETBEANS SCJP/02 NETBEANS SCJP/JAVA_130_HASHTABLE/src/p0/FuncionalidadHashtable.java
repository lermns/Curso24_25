// Crear una clase que utilice los métodos más comunes de la implementación
// de la interfaz Map, Hashtable.

// Nota: Un mapa se compone de la pareja clave - valor, de forma que para poder
//       acceder a un determinado valor de dicho mapa, se ha de proporcionar la
//       clave correspondiente, que será siempre única (es un objeto - equals).

//       Hashtable, a diferencia de HashMap, no permite la utilización de null ni
//       en el key ni el value (generaría error de ejecución). Es preferible utilizar
//       HashMap antes que Hashtable ya que esta última está obsoleta y es además
//       sincronizada (la sincronización consume recursos de la máquina).


package p0;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;


public class FuncionalidadHashtable {

    public static void main(String[] args) {
        
        // <CAMPO KEY   ,   CAMPO VALUE>
        // <Object      ,   Object>
                
        Hashtable mapaNumeros = new Hashtable();
        
        // En los Map se hace uso de put(X,Y) mientras que en los 
        // Collection se emplea add(X)
        mapaNumeros.put("uno", 1);
        mapaNumeros.put("dos", 2);
        mapaNumeros.put("tres", 3);

        // Las colecciones sólo pueden almacenar objetos. En el caso de tratar
        // de usar un primitivo, se producirá un AUTOBOXING al introducir el
        // elemento en la colección (Java 5.0 y superiores).
        
        System.out.println(mapaNumeros);
        
        System.out.println("\n________________________\n");
        
        Object elementoAntiguo = mapaNumeros.put("uno", 111111);
        
        System.out.println(mapaNumeros);
        
        System.out.println("ELEMENTO ANTIGUO = " + elementoAntiguo);
        
        System.out.println("\n________________________\n");        
        
        System.out.println("TIENES LA CLAVE dos ... " + 
                mapaNumeros.containsKey("dos"));

        System.out.println("TIENES LA CLAVE diez ... " + 
                mapaNumeros.containsKey("diez"));

        System.out.println("\n________________________\n");        
        
        System.out.println("TIENES EL VALOR 2 ... " + 
                mapaNumeros.containsValue(2));

        System.out.println("TIENES EL VALOR 10 ... " + 
                mapaNumeros.containsKey(10));
        
        System.out.println("clave uno ---> " + mapaNumeros.get("uno"));
        
        System.out.println("\n________________________\n");        
        
        Enumeration keys = mapaNumeros.keys(); // enumeración con las claves.
        
        // a partir de la clave podemos obtener el valor correspondiente.
        while(keys.hasMoreElements()) {
            Object laClave = keys.nextElement();
            Object elValor = mapaNumeros.get(laClave);
            System.out.println(laClave + " ---> " + elValor);
        }
        
        System.out.println("\n________________________\n");        
        
        Collection coleccion = mapaNumeros.values(); // colección con los valores.
        Iterator it = coleccion.iterator();
        while(it.hasNext()) {
            System.out.println("valor ---> " + it.next());
        }
        
        System.out.println("\n________________________\n");        
        
        Enumeration valores = mapaNumeros.elements(); // enumeración con los valores.
        while(valores.hasMoreElements()) {
            System.out.println("valor -------------> " + valores.nextElement());
        }
        
        System.out.println("\n________________________\n");        
        
        Object elementoEliminado = mapaNumeros.remove("uno");
        System.out.println("ELEMENTO ELIMINADO ... "  + elementoEliminado);
        System.out.println(mapaNumeros);
      
    }

} 