// Crear la clase abstracta Bebida como punto de inicio en la jerarquí de clases. Dispondrá
// de los atributos nombre, precio y volumen. El nombre se obtiene por instrospección a
// partir de la clase mientras que precio y volumen serán asignados por el constructor de la
// propia clase hija (anteriormente lo hicimos aprovechando el encadenamiento de constructores
// entre clases, forma que se podría considerar como "la más elegante").

// Sobrescribir el método toString para dar información sobre el objeto Bebida instanciado.


package bebidas;

public abstract class Bebida {

    protected String    nombre;
    protected int       precio;
    protected int       volumen;
    
    protected Bebida() {
        nombre = getClass().getSimpleName().toUpperCase();
    }
        
    public int obtenerPrecio() {
        return precio;
    }

    public int obtenerVolumen() {
        return volumen;
    }
       
    @Override
    public String toString() {
        return nombre.toUpperCase() + " - " + precio + " € - " + volumen + " Cl";
    }
    
}