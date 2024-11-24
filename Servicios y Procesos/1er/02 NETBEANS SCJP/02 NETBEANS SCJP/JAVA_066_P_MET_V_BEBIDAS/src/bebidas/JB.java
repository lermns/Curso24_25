// Crear la clase hija de Bebida denominada JB.


package bebidas;

import interfacesbebida.InterfazPrecios;
import interfacesbebida.InterfazVolumen;

public class JB extends Bebida {

    public JB() {
        precio      = InterfazPrecios.PRECIO_JB;
        volumen     = InterfazVolumen.VOLUMEN_JB;
    }   
}