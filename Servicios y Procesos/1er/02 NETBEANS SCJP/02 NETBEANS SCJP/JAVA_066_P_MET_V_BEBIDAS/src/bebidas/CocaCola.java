// Crear la clase hija de Bebida denominada CocaCola.


package bebidas;

import interfacesbebida.InterfazPrecios;
import interfacesbebida.InterfazVolumen;

public class CocaCola extends Bebida {

    public CocaCola() {
        precio      = InterfazPrecios.PRECIO_COCACOLA;
        volumen     = InterfazVolumen.VOLUMEN_COCACOLA;
    }   
}