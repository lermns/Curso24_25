// Crear la clase (no abstracta) Persona en la que se definirán los atributos nombre y
// edad. Dotar a la clase de un constructor parametrizado para inicializarlos y realizar
// la sobrescritura del método toString.


package p0;

// clase NO abstracta ... se puede instanciar (está completa, acabada).
public class Persona {

    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "NOMBRE = " + nombre + ", EDAD = " + edad;
    }   
}