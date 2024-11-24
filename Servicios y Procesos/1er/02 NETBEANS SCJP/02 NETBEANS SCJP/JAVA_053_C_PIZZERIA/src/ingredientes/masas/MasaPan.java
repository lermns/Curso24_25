// Crear la clase MasaPan como un tipo de Ingrediente para consignar la masa.


package ingredientes.masas;

import ingredientes.Ingrediente;
import interfaces.InterfazPrecios;

public class MasaPan extends Ingrediente {

    public MasaPan() {
        super(InterfazPrecios.PRECIO_MASA_PAN);
    }    
}