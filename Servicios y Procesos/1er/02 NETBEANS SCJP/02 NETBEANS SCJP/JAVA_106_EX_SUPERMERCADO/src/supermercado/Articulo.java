// Crear la clase Articulo como punto de inicio en la jerarquía de clases. Se
// dispone de los atributos nombre y precio además de los métodos necesarios
// para trabajar con los mismos, obtener y establecer precio. Se sobrescribe
// el método toString para dar información sobre el artículo.

// Nota: el método establecerPrecio se utilizará en el momento en el que se
// detecte que el artículo Cebolla carece de él, para solventar el error.


package supermercado;

public abstract class Articulo {

    protected String nombre;
    protected Double precio;
            
    protected Articulo() {
        nombre = getClass().getSimpleName().toUpperCase();
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public Double obtenerPrecio() {
        return precio;
    }

    // SETTER POR SI EL ARTICULO HA PERDIDO LA ETIQUETA DEL PRECIO.
    public void establecerPrecio(Double precio) { 
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return nombre + " _ " + precio;
    }
}