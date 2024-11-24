// Crear la subclase de Ingrediente, Tomate.


package ingredientes;

import interfaces.InterfazPrecios;

public class Tomate extends Ingrediente {

    public Tomate() {
        super(InterfazPrecios.PRECIO_TOMATE);
    }
}