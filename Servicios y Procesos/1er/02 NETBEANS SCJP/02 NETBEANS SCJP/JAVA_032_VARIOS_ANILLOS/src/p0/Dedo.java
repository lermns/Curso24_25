// Crear la clase Dedo que contendrá por composición débil un objeto de tipo Anillo
// (el tipo "NINGUNO" es uno más. La clase dispone de un constructor que requiere el
// nombre del dedo (pulgar, índice ... etc) y la posición del mismo [1..5]. El objeto
// de tipo Anillo, se crea automáticamente y de forma aleatoria en el momento de instaciar
// el objeto Dedo.

// Se sobrescribe el método toString de Dedo para indicar nombre, posición y anillo que le
// ha correspondido.


package p0;

public class Dedo {

    private String nombre;
    private int posicion;
    private Anillo anillo;
    
    public Dedo(String nombre, int posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
        anillo = new Anillo(); // crear objeto Anillo aleatoriamente.
    }

    @Override
    public String toString() {
        
        String texto = nombre + " - " + posicion;
        
        String textoAnillo = anillo.toString();        
        
        if("NINGUNO".equals(textoAnillo)) {
            return texto; // no añadimos el texto "NINGUNO".
        }
        
        return texto + " - " + textoAnillo; // añadimos el tipo de Anillo.
    }   
}