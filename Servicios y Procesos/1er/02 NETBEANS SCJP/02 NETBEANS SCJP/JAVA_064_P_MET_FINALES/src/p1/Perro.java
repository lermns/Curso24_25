// Crear una clase Perro que demuestre cómo un parámetro de entrada referenciado y declarado
// como final en la entrada de un método no permite una posteriror desvinculación, pero sí,
// al menos en principio, la modificación de dicho objeto (siempre y cuándo sus atributos no
// sean igualmente finales). Utilizar el patrón de clase JavaBean.


package p1;

public class Perro {

    private String nombre;
    
    public Perro(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
}


class Prueba {
    
    public static void cambiarNombre(final Perro perro, final String nombre) {
        perro.setNombre(nombre);
        
        // final sobre tipo referenciado no permite la desvinculación del objeto 
        // asignado originalmente, pero sí, en principio, su modificación interna.
        
        //perro = null; // error. No pueden apuntar hacia otro "lado".
        //nombre = null;
    }

    
    public static void main(String[] args) {
        
        Perro perro = new Perro("Boby");        
        
        System.out.println("---> " + perro.getNombre());        

        cambiarNombre(perro, "Cancerbero");
        
        System.out.println("---> " + perro.getNombre());
    }
    
}