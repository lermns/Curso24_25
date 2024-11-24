// Crear la clase MasaNormal como un tipo de Ingrediente para consignar la masa.


package ingredientes.masas;

import ingredientes.Ingrediente;
import interfaces.InterfazPrecios;

public class MasaNormal extends Ingrediente {

    public MasaNormal() {
        super(InterfazPrecios.PRECIO_MASA_NORMAL);
    }   
}