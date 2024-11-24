// Crear la clase CartaPoker en base a los atributos palo(tipo enumerado PalosPoker)
// y numero(valor int). Establecer un constructor parametrizado que pida ambos y
// sobrescribir el método toString para informar sobre la carta.


package p1;

import p0.PalosPOKER;

public class CartaPOKER {
    
    private PalosPOKER palo;
    private int numero;
    
    public CartaPOKER(PalosPOKER palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "[" + palo + ", " + numero + "]";
    }   
}