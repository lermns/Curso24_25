// Crear la subclase de Ingrediente, Champi.


package ingredientes;

import interfaces.InterfazPrecios;

public class Champi extends Ingrediente {

    public Champi() {
        super(InterfazPrecios.PRECIO_CHAMPI);
    }    
}