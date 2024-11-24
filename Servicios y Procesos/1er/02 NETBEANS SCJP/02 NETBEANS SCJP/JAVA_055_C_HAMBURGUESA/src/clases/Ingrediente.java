// Crear la clase Ingrediente, que constituirá el supertipo de todos los ingredientes
// que puedan emplearse a la hora de crear la hamburguesa. Se empleará una clase de
// tipo abstracto(no instanciable) ya que vamos a definir en ella atributos que se
// heredaran por las hijas (nombre y precio). El atributo nombre corresponde al nombre
// del ingrediente (la clase) mientras que el precio se obtendrá de la interfaz Precios.
// Se añade además el método obtenerPrecio que nos devolverá el valor del atributo
// precio (se hereda y modifica en la clase hija correspondiente).


package clases;

public abstract class Ingrediente {

    protected String nombre;
    protected double precio;
    
    public Ingrediente() {
        nombre = getClass().getSimpleName().toUpperCase(); // nombre de la clase en mayúsculas.
    }
        
    public double obtenerPrecio() {
        return precio;
    }
    
    @Override
    public String toString() {
        return "[" + nombre + " - " + precio + "]"; 
    }
}