// Crear la clase Pimiento, heredera de Articulo.


package supermercado;

import interfaces.InterfazPrecios;

public class Pimiento extends Articulo {

    public Pimiento() {
        precio = InterfazPrecios.PRECIO_PIMIENTO;
    }   
}