// Crear la clase abstracta Envase como punto de inicio de jerarquía de clases. Se
// dispondrá de los atributos capacidad, nombre, material y color que serán heredados
// por las subclases de ésta. Un constructor parametrizado se encargará de inicializar
// sus valores, mientras que el método String mostrará por pantalla información sobre
// el estado del objeto instanciado a partir de dichas clases hijas.

// Nota: en este ejercicio no se ha declarado ningún método abstracto, ya que lo que
// se quiere mostrar es la transmisión de atributos hacia las subclases y cómo éstas,
// a través del encadenamiento de constructores, pueden inicializar dichos atributos.


package p0;

public abstract class Envase {
    
    protected int       capacidad;
    protected String    nombre;
    protected String    material;
    protected String    color;    
    
    protected Envase(int capacidad, String material, String color) {
        nombre = getClass().getSimpleName().toUpperCase();
        this.capacidad = capacidad;
        this.material = material;
        this.color = color;
    }
    
    @Override
    public String toString() {
        String texto = "";
        texto += "NOMBRE = " + nombre + "\n";
        texto += "CAPACIDAD = " + capacidad + "\n";
        texto += "MATERIAL = " + material + "\n";
        texto += "COLOR = " + color + "\n";
        return texto;
    }
}