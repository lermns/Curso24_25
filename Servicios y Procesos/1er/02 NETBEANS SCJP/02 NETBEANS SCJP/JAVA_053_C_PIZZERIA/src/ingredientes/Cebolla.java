// Crear la subclase de Ingrediente, Cebolla.


package ingredientes;

import interfaces.InterfazPrecios;

public class Cebolla extends Ingrediente {

    public Cebolla() {
        super(InterfazPrecios.PRECIO_CEBOLLA);
    }   
}