// Crear la clase MasaFina como un tipo de Ingrediente para consignar la masa.


package ingredientes.masas;

import ingredientes.Ingrediente;
import interfaces.InterfazPrecios;

public class MasaFina extends Ingrediente {

    public MasaFina() {
        super(InterfazPrecios.PRECIO_MASA_FINA);
    }    
}