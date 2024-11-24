// Crear la clase Concesionario, la cuál dispodrá de un atributo de tipo TreeMap
// (mapa con ordenación natural) para poder almacenar sus elementos (tipo Coche).
// Definir en ella diversos métodos para conseguir una ordenación interna en base a:
// 1. el modelo (usa el campo KEY sin utilizar ningun comparador).
// 2. la fecha (usa el campo VALUE para lo cuál se utiliza comparador de fecha).
// 3. el precio (usa el campo VALUE, usa comparador de precio y elige asc. o desc.).

// Nota: Para poder ordenar por el campo VALUE (atributos precio y fecha) hay que
//       obtener los valores como una colección a parte y a continuación utilizar
//       el método sort de la clase de utilidad java.util.Collections, el cuál
//       sólo admite un List. Así, previamente, deberemos convertir los
//       valores de la colección TreeMap (no confundir con Collection) en una
//       colección de tipo List (como una ArrayList), olvidándonos de los keys.
//       Se imprime la nueva colección que contendrá los valores ya ordenados.

package concesionarios;

import coches.Coche;
import comparadores.ComparadorFecha;
import comparadores.ComparadorPrecio;
import interfaces.Orden;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;


public class Concesionario {

    private TreeMap<String, Coche> losCoches; // [KEY = modelo - VALUE = Coche: modelo + fecha + precio ]

    
    public Concesionario() {
        // de usarse un Comparator al instanciar el TreeMap, actuaría sobre el KEY no el VALUE, luego
        // sólo podríamos ordenar por el modelo del coche y no por su fecha ni por su precio.
        losCoches = new TreeMap<String, Coche>(); 
    }
    
    
    public void añadirCoche(String modelo, int año, int precio) {
        Coche coche = new Coche(modelo, año, precio);        
        añadirCoche(coche); // delegar el añadido al siguiente método.
    }

    
    public void añadirCoche(Coche coche) {
        losCoches.put(coche.getModelo(), coche); // introducir en el mapa.
    }

    // ESTE MÉTODO NOS PERMITE ORDENAR LOS COCHES POR MODELO (usa campo KEY y ningún comparador).
    public void verCochesPorModelo() {
        // Sacar las claves (keys) del mapa.
        Iterator it = losCoches.keySet().iterator();
        
        while(it.hasNext()) {
            System.out.println(losCoches.get(it.next()));
        }        
    }

    
    private List<Coche> convertirMapList() {
        
        // OBTENER LA COLUMNA VALUES DEL MAPA Y PROCEDER A ORDENARLA EN BASE
        // AL MÉTODO sort DE LOS ArrayList Y EL COMPARADOR DE FECHA O PRECIO.
        
        // ASÍ, NO NECESITAREMOS EN NINGÙN CASO LA COLUMNA DE KEYS, SÓLO LA
        // DE VALUES Y TENDREMOS QUE TRANSFORMAR DICHA COLUMNA EN UN List PARA
        // PODER HACER USO DEL SU MÉTODO sort.
        
        // convertir el mapa(Map) en una lista(List) para poder hacer uso del método de
        // ordenación sort disponible en la clase de utilidad java.util.Collections,
        // ya que dicha clase no admite un Map (en este caso TreeMap), sólo un List.

        // sacar los valores del TreeMap devueltos como un Collection. Nos interesan los
        // valores (campo VALUE), las claves (campo KEY) no sirven para obtener fecha y precio,
        // ya que están constituidas por un simple String que corresponde al modelo del
        // coche ... ejemplo: PORSCHE 911 ... ahí no está almacenado ni precio ni fecha.
        
        // NOTA: la clase real utilizada para la implementación la pone la JVM.
        Collection<Coche> cochesCollection = losCoches.values();
        
        // generar el ArrayList a partir del Collection anterior (usar su constructor).
        ArrayList<Coche> cochesList = new ArrayList<Coche>(cochesCollection);
    
        // HEMOS CONSEGUIDO CONVERTIR EL TreeMap(valores, no claves) en un ArrayList.
        // devolver ese ArrayList visto como un List (su supertipo).
        return cochesList;
    }
    
    
    // ESTE MÉTODO NOS PERMITE ORDENAR LOS COCHES POR FECHA (usa campo VALUE y el comparador de fecha). 
    public void verCochesPorFecha() {  
        
        List<Coche> cochesList = convertirMapList(); // obtener los valores del TreeMap como List.
        
        Collections.sort(cochesList, new ComparadorFecha()); // ordenar valores a través del comparador. Pide List.
        
        Iterator it = cochesList.iterator(); // EL QUE QUEDA ORDENADO ES EL LIST, NO EL COLLECTION.
        
        while(it.hasNext()) {
            System.out.println(it.next());
        }        
    }
    

    // ESTE MÉTODO NOS PERMITE ORDENAR LOS COCHES POR PRECIO (usa campo VALUE y el comparador de precio).
    // ADEMÁS, NOS PERMITE DECIDIR SI SE QUIERE REALIZAR LA ORDENACIÓN EN FORMA ASCENDENTE O DESCENDENTE.
    // MAYOR_MENOR_PRECIO ---> false --> ascendente
    // MENOR_MAYOR_PRECIO ---> true ---> descendente.
    public void verCochesPorPrecio(boolean ordenInverso) {  
        
        List<Coche> cochesList = convertirMapList(); // convertir para poder usar sort de Collections.
        
        if(ordenInverso) {
            Collections.sort(cochesList, new ComparadorPrecio(Orden.MAYOR_MENOR_PRECIO));
        } else {
            Collections.sort(cochesList, new ComparadorPrecio(Orden.MENOR_MAYOR_PRECIO));        
        }
        
        Iterator it = cochesList.iterator();
        
        while(it.hasNext()) {
            System.out.println(it.next());
        }        
    }    

}