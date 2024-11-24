// Crear la clase Pan, heredera de Articulo.


package supermercado;

import interfaces.InterfazPrecios;

public class Pan extends Articulo {

    public Pan() {
        precio = InterfazPrecios.PRECIO_PAN;
    }   
}