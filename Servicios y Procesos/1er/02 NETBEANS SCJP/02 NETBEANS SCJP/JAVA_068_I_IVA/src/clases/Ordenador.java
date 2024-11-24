// La subclase Ordenador.


package clases;

import interfaces.InterfacePrecios;

public class Ordenador extends Articulo {

    public Ordenador() {
        super(InterfacePrecios.PRECIO_ORDENADOR);
    }   
}