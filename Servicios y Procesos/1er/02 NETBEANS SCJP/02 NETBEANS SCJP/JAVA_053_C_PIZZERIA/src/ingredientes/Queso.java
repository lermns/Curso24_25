// Crear la subclase de Ingrediente, Queso.


package ingredientes;

import interfaces.InterfazPrecios;

public class Queso extends Ingrediente {

    public Queso() {
        super(InterfazPrecios.PRECIO_QUESO);
    }   
}