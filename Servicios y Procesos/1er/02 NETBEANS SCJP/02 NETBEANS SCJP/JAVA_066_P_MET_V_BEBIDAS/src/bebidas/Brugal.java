// Crear la clase hija de Bebida denominada Brugal.


package bebidas;

import interfacesbebida.InterfazPrecios;
import interfacesbebida.InterfazVolumen;

public class Brugal extends Bebida {

    public Brugal() {
        precio      = InterfazPrecios.PRECIO_BRUGAL;
        volumen     = InterfazVolumen.VOLUMEN_BRUGAL;
    }    
}