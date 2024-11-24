// Crear una clase Caballo que ponga de manifiesto la relación de composición fuerte
// que existe entre ella y la clase Cabeza (cardinalidad 1-1).

// La composición se realiza en base a un atributo de tipo Cabeza y de caracter privado,
// que se inicializa en el constructor de la clase contenedora (Caballo).

package p0;

public class Caballo {

    private Cabeza cabeza; // COMPOSICIÓN FUERTE ... VALOR INICIAL = null.
    
    // LA CLASE CABALLO SE COMPONE DE UN OBJETO DE LA CLASE CABEZA.
    
    public Caballo() {
        this.cabeza = new Cabeza();  // SE INICIALIZA LA VARIABLE DESDE 
                                // EL CONSTRUCTOR DE LA CLASE CABALLO.
    }
    
    @Override
    public String toString() {
        return "EL CABALLO TIENE UNA " + cabeza.toString();
    }
    

    public static void main(String[] args) {
        
        Caballo caballo = new Caballo(); // SE HAN CREADO 2 OBJETOS.
        System.out.println(caballo);
    }
}