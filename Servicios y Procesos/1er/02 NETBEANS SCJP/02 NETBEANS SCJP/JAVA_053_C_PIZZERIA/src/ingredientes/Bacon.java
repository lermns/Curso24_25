// Crear la subclase de Ingrediente, Bacon.


package ingredientes;

import interfaces.InterfazPrecios;

public class Bacon extends Ingrediente {

    public Bacon() {
        super(InterfazPrecios.PRECIO_BACON);
    }    
}