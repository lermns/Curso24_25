// Crear la clase hija de Bebida denominada Larios.


package bebidas;

import interfacesbebida.InterfazPrecios;
import interfacesbebida.InterfazVolumen;

public class Larios extends Bebida {

    public Larios() {
        precio      = InterfazPrecios.PRECIO_LARIOS;
        volumen     = InterfazVolumen.VOLUMEN_LARIOS;
    }   
}