// Crear la clase abstracta Sandwich dotada de un bloque de incialización
// estático para establecer la fecha de envasado, que será un atributo estático
// y final de la clase (todos los objetos de la presente ejecución tendrán
// dicha fecha). Sobrescribir el método toString para indicar la fecha, el nombre
// del sandwich y los ingredientes que contine (utilizar un simple String).


package p0;

import java.util.Date;

public abstract class Sandwich {

    static {
        // ESTABLECER LA FECHA DE ENVASADO DE CADA DÍA.
        // LA APLICACIÓN ARRANCA A LAS 5:00 AM, FABRICA LOS SANDWICH Y AL
        // FINAL DEL DÍA SE APAGA, VOLVIENDO A ARRANCAR A DÍA SIGUIENTE.
        fechaEnvasado = new Date().toString();
    }
    
    protected static final String fechaEnvasado;
    protected String ingredientes;
    
    @Override
    public String toString() {
        
        String texto = "";
        
        texto += "FECHA ENVASADO ..." + fechaEnvasado + "\n";
        texto += "TIPO ..." + getClass().getSimpleName().toUpperCase() + "\n";
        texto += "INGREDIENTES ..." + ingredientes + "\n";
        
        return texto;
    }
}