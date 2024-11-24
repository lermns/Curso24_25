// Crear la subclase PizzaBarbacoa (hereda de Pizza) de forma que su sobrecarga
// de constructores permita no tener que indicar el tipo de masa(en cuyo caso se
// utilizará NORMAL). Un segundo constructor nos permitirá elegir citado tipo en
// base a la constante declarada en InterfazNombres ('F','N','P').

// Los ingredientes que debe añadir, a los ya impuestos por la invocación al 
// constructor de la madre son: SalsaBarbacoa, Ternera y Bacon.


package pizzas;

import ingredientes.Bacon;
import ingredientes.SalsaBarbacoa;
import ingredientes.Ternera;
import interfaces.InterfazNombres;

public final class PizzaBarbacoa extends Pizza {

    public PizzaBarbacoa() {
        this(InterfazNombres.NORMAL);
    }
        
    public PizzaBarbacoa(char tipoMasa) {
        super(tipoMasa);
        
        losIngredientes.add(new SalsaBarbacoa());
        losIngredientes.add(new Ternera());
        losIngredientes.add(new Bacon());
    }
}