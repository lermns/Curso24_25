// Crear la clase Vitrina que contendrá un atributo de tipo TreeSet marcado
// con género <Pastel>. En el constructor de la clase se generará el objeto
// TreeSet en base a un comparador de medida o de precio (la ordenación de
// los elementos se efectuará en base al mismo en lugar de lo que indique
// el método compareTo de la clase Pastel). Añadir distintos objetos Pastel
// a la colección y establecer un método para poder consultar los pasteles
// que hay en la Vitrina.


package pasteleria;

import comparadores.ComparadorMedida;
import comparadores.ComparadorPrecioPastel;
import enumerados.Medidas;
import enumerados.Sabores;
import java.util.Iterator;
import java.util.TreeSet;


public class Vitrina {

    TreeSet<Pastel> pasteles;

    // CONSTRUCTOR. SE DECIDE QUE COMPARADOR USAR.
    public Vitrina() {
        
        // ELEGIR UNO DE LOS 2 COMPARADORES Y VER EL RESULTADO:
        
        // 1. CREAR EL TREESET UTILIZANDO COMPARADOR DE PRECIO.
        pasteles = new TreeSet(new ComparadorPrecioPastel());
        
        // 2. CREAR EL TREESET UTILIZANDO COMPARADOR DE MEDIDA.
        // pasteles = new TreeSet(new ComparadorMedida());
        
        introducirPasteles(); // introducir los pasteles (se ordenan solos).
        mostrarPasteles();    // mostrar los pasteles.
    }
    
    private void introducirPasteles() {
        
        Pastel p1 = new Pastel(Sabores.FRESA, Medidas.NORMAL, 200);
        Pastel p2 = new Pastel(Sabores.CHOCOLATE, Medidas.SUPER, 70);
        Pastel p3 = new Pastel(Sabores.VAINILLA, Medidas.GRANDE, 30);
        
        // AÑADIR LOS PASTELES DESCOLOCADOS:
        pasteles.add(p3);
        pasteles.add(p1);
        pasteles.add(p2);
        
        // ... UNA VEZ INTRODUCIDOS, SE ORDENARAN POR SI SÓLOS EN BASE
        // AL CÓDIGO QUE ESTABLECE EL MÉTODO compare(X,Y) DEL COMPARADOR
        // EMPLEADO.
    }
    
    private void mostrarPasteles() {
        Iterator it = pasteles.iterator();
        
        while(it.hasNext()) {
            System.out.println("---> " + it.next());
        }        
    }   

}