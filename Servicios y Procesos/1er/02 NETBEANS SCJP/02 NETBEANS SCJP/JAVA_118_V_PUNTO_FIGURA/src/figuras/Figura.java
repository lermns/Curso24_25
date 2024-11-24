// Crear la clase Figura como composición de puntos individuales. Para ello,
// dotar a la clase de un Vector de objeto Punto y establecer el método
// visualizarPuntos para que a través de un bucle for-each, un iterador y un
// enumerador, se impriman por pantalla los elementos que componen la figura.
// El conjunto de puntos se recibirá a través del método definirPunto, que 
// utilizará una cadena de entrada de parámetros variables.


package figuras;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import puntos.Punto;


public class Figura {

    private Vector<Punto> losPuntos;

    // La figura se compone de un Vector de objetos de tipo Punto.
    public Figura() {
        losPuntos = new Vector<Punto>();
    }
    
    
    public void definirPuntos(Punto ... puntos) {
        for (Punto punto : puntos) {
            losPuntos.add(punto);            
        }
    }
    
    
    public void visualizarPuntos() {

        System.out.println("\n CON BUCLE FOR-EACH \n");        
        
        for (Punto punto : losPuntos) {
            System.out.println(punto);
        }
        
        System.out.println("\n CON ITERATOR \n");
    
        // Hay que marcar el iterador con género. El que la colección ya esté
        // marcada no es suficiente.
        Iterator<Punto> it = losPuntos.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
                
        System.out.println("\n CON ENUMERATION \n");
        
        Enumeration<Punto> e = losPuntos.elements();
        while(e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }   

}