// La clase del ingrediente Carne.


package clases;

import interfaces.Precios;

public class Carne extends Ingrediente {

    public Carne() {
        // En este caso, es la propia clase hija la que le da valor al atributo heredado
        // en lugar de enviarselo al constructor de la madre.
        precio = Precios.PRECIO_CARNE;
    }    
}