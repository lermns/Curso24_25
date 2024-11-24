// Crear la clase hija de Bebida denominada Absolut.


package bebidas;

// NOTA: Si no colocamos las importaciones en orden ascendente, nos dará un Warning.
// Pulsar sobre la bombilla que aparecerá, de modo que los organice automáticamente.

import interfacesbebida.InterfazPrecios;
import interfacesbebida.InterfazVolumen;

public class Absolut extends Bebida {

    public Absolut() {
        precio      = InterfazPrecios.PRECIO_ABSOLUT;
        volumen     = InterfazVolumen.VOLUMEN_ABSOLUT;
    }    
}