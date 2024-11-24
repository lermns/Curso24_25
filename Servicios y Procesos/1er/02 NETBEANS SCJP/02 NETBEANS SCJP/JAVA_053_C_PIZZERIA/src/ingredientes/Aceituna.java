// Crear la subclase de Ingrediente, Aceituna.


package ingredientes;

import interfaces.InterfazPrecios;

public class Aceituna extends Ingrediente {

    public Aceituna() {
        super(InterfazPrecios.PRECIO_ACEITUNA);
    }    
}