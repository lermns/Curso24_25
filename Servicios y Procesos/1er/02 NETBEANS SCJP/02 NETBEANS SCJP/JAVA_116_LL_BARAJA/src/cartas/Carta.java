// Crear la clase Carta que se compone de un Palo (tipo enumerado) y un número
// que va del 1(as) al 13(rey). Definir un método que permita consultar el
// número de la carta (el palo no es necesario).


package cartas;

import enumerados.Palos;


public class Carta {

    private Palos palo;
    private int numero;

    public Carta(Palos palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    @Override
    public String toString() {
        return "[" + palo + ", " + numero + "]";
    }    
}