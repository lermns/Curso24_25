// Crear una clase que encapsule los atributos nombre, raza y edad para modelizar
// el concepto "gato". Dotar a la clase de un constructor parametrizado para poder
// asignar valores a dichos atributos en el momento en el que se constituya el 
// objeto. Sobrescribir el método toString para informar sobre el estado del objeto
// creado (el valor de sus atributos en un determinado momento del tiempo).


package p0;

public class Gato {

    // CARACTERÍSTICAS DE LA CLASE GATO ... ATRIBUTOS O VARIABLES DE INSTANCIA.
    // BLANKED VARIABLES ... o variables en blanco (inicializadas a su valor por defecto):
    
    private String  nombre;
    private String  raza;
    private int     edad;
    
    public Gato(String nombre, String raza, int edad) {        
        // cada objeto Gato tendrá su propia de las variables, independiente del resto.
        this.nombre     = nombre;
        this.raza       = raza;
        this.edad       = edad;
    }
    
    @Override
    public String toString() {
        return nombre + " _ " + raza + " _ " + edad;
    }     
    
    public static void main(String[] args) {
        Gato g1 = new Gato("ISIDORO", "PERSA", 3);
        System.out.println(g1);

        System.out.println("\n________________________\n");
        
        Gato g2 = new Gato("GARFIELD", "CALLEJERO", 14);
        System.out.println(g2);
    
        System.out.println("\n________________________\n");
    }   
}