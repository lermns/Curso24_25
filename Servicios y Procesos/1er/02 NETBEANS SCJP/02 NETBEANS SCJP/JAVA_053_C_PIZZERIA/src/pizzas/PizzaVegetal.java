// Crear la subclase PizzaVegetal (hereda de Pizza) de forma que su sobrecarga
// de constructores permita no tener que indicar el tipo de masa(en cuyo caso se
// utilizará NORMAL). Un segundo constructor nos permitirá elegir citado tipo en
// base a la constante declarada en InterfazNombres ('F','N','P').

// Los ingredientes que debe añadir, a los ya impuestos por la invocación al 
// constructor de la madre son: Aceituna, Cebolla y Champi.


package pizzas;

import ingredientes.Aceituna;
import ingredientes.Cebolla;
import ingredientes.Champi;
import interfaces.InterfazNombres;

public final class PizzaVegetal extends Pizza {

    public PizzaVegetal() {
        this(InterfazNombres.NORMAL);
    }
        
    public PizzaVegetal(char tipoMasa) {
        super(tipoMasa);
        
        losIngredientes.add(new Aceituna());
        losIngredientes.add(new Cebolla());
        losIngredientes.add(new Champi());
    }
}