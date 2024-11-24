// Crear la clase Tomate, heredera de Articulo.


package supermercado;

import interfaces.InterfazPrecios;

public class Tomate extends Articulo {

    public Tomate() {
        precio = InterfazPrecios.PRECIO_TOMATE;
    }   
}