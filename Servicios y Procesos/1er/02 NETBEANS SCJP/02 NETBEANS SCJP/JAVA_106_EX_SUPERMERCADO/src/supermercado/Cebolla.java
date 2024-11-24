// Crear la clase Cebolla, heredera de Articulo. Ésta clase no tiene precio.


package supermercado;

import interfaces.InterfazPrecios;

public class Cebolla extends Articulo {

    public Cebolla() {
        // ESTE ARTÍCULO NO TIENE PRECIO, LO HA PERDIDO.
        precio = InterfazPrecios.PRECIO_CEBOLLA; // es null en la interfaz.
    }    
}