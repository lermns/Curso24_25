// Crear la clase Lechuga, heredera de Articulo.


package supermercado;

import interfaces.InterfazPrecios;

public class Lechuga extends Articulo {

    public Lechuga() {
        precio = InterfazPrecios.PRECIO_LECHUGA;
    }   
}