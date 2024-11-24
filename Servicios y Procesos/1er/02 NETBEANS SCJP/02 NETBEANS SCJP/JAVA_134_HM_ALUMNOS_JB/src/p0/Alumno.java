// Crear la clase Alumno como de tipo JavaBean, disponiéndose en la misma de
// Los atributos privados, nombre, edad y si es hombre o mujer (booleano).
// Establecer los getter y setters correspondientes para poder manejarlos.

// Nota: Un JavaBean se utiliza para encapsular información. En aplicaciones
//       de tipo web, se usan para interconectar las 3 capas de un modelo,
//       vista, controlador(MVC), a lo cuál se le llama TRANSFER-OBJECT (un
//       patrón de diseño).


package p0;


public class Alumno {

    // CLASE JAVABEAN:
    
    private String nombre;
    private int edad;
    private boolean hombreMujer;

    // CONSTRUCTOR PÚBLICO SIN ARGUMENTOS(VALORES POR DEFECTO) QUE SIEMPRE
    // SE REQUIERE AL HABLAR DE UN JAVABEAN:
    // clase pública con constructor público sin argumentos ... opcionalmente
    // dispondrá de atributos privados y los métodos getters y setters 
    // correspondientes. En este ejercicio no lo usaremos.
    public Alumno() {}
        
    // CONSTRUCTOR PÚBLICO PARAMETRIZADO:
    public Alumno(String nombre, int edad, boolean hombreMujer) {
        this.nombre = nombre;
        this.edad = edad;
        this.hombreMujer = hombreMujer;
    }

    // GETTERS Y SETTERS (RECUPERA Y ASIGNA):
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isHombreMujer() { // para los boolean usamos isXXX.
        return hombreMujer;
    }

    public void setHombreMujer(boolean hombreMujer) {
        this.hombreMujer = hombreMujer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    // MÉTODO TOSTRING:
    @Override
    public String toString() {
        
        String texto = "";
        
        texto += "Nombre = " + nombre.toUpperCase() + "\n";
        texto += "Edad = " + edad + "\n";
        texto += "Hombre/Mujer = " + (hombreMujer?"MUJER":"HOMBRE") + "\n";
        
        return texto;
    }   

}