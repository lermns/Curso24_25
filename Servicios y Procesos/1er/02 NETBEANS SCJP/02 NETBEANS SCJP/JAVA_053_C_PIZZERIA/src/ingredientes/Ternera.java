// Crear la subclase de Ingrediente, Ternera.


package ingredientes;

import interfaces.InterfazPrecios;

public class Ternera extends Ingrediente {

    public Ternera() {
        super(InterfazPrecios.PRECIO_TERNERA);
    }    
}