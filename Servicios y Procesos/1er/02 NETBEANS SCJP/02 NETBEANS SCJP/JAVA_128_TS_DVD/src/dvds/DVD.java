// Crear una clase cuyo nombre sea DVD. Se dispone de los atributos titulo,
// genero y precio, a los que se dará valor a través de un constructor 
// parametrizado. Se dispone de los correspondientes métodos getter y se
// sobrescribe el método toString. La clase debe implementar la interfaz
// Comparable para que ordene de forma natural por precio (ésto no evita
// que más tarde podamos hacer uso de un Comparator para elegir otra forma 
// de ordenación).


package dvds;

import enumerados.Generos;


// Una misma clase puede hacer uso de Comparable y usar un Comparator, de forma
// simultanea.
public class DVD implements Comparable<DVD> {

    private String titulo;
    private Generos genero;
    private Double precio; // se utiliza en este ejemplo un wrapper.

    public DVD(String titulo, Generos genero, Double precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }

    public Generos getGenero() {
        return genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getTitulo() {
        return titulo;
    }

    // COMPARABLE ... LE PEDIMOS QUE ORDENE POR PRECIO
    @Override
    public int compareTo(DVD dvd) {
        return precio.compareTo(dvd.precio); 
    }
       
    @Override
    public String toString() {
        return "[" + titulo + ", " + genero + ", " + precio + "]";
    }

}