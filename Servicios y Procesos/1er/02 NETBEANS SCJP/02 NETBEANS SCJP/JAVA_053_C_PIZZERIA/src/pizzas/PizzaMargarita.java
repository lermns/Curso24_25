// Crear la subclase PizzaMargarita (hereda de Pizza) de forma que su sobrecarga
// de constructores permita no tener que indicar el tipo de masa(en cuyo caso se
// utilizará NORMAL). Un segundo constructor nos permitirá elegir citado tipo en
// base a la constante declarada en InterfazNombres ('F','N','P').

// Esta subclase de Pizza no añade ningún ingrediente extra.


package pizzas;

import interfaces.InterfazNombres;

public final class PizzaMargarita extends Pizza {

    public PizzaMargarita() {
        this(InterfazNombres.NORMAL);
    }
        
    public PizzaMargarita(char tipoMasa) {
        super(tipoMasa);
    }
}