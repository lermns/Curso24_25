// Crear la clase abstracta Ingrediente como punto de inicio en la jerarquía de clases.
// Se dispone de los atributos nombre y precio. El nombre se obtendrá por introspección
// (Java Reflection) mientras que el precio se designará a partir del valor de la interfaz
// InterfazPrecios. Se dota a la clase de un método para consultar el precio del Ingrediente
// y se sobrescribe el método toString.


package ingredientes;

public abstract class Ingrediente {

    // Variables protegidas a heredar por las hijas.
    protected String nombre;
    protected double precio;
    
    // determinanción del nombre del ingrediente y su precio.
    protected Ingrediente(double precio) {
        // método de instancia, luego depende del tipo del tipo del objeto.
        nombre = getClass().getSimpleName().toUpperCase();
        // El constructor de la madre recibe el valor enviado por el constructor de la
        // hija. Así, se hereda con el valor decidido por la clase hija.
        this.precio = precio;
    }
    
    public double obtenerPrecio() {
        return precio;
    }
        
    @Override
    public String toString() {
        return nombre + " _ " + precio;
    }   
}