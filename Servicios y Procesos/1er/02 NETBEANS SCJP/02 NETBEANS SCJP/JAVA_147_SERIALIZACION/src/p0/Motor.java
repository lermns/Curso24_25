// Crear una clase Motor que sobrescriba el método toString para indicar
// que se trata de un motor de 1600 centimetros cúbicos. La clase no
// implementa la interfaz Serializable ni define ningún atributo o método.


package p0;

// NO MARCAMOS LA CLASE CÓMO Serializable.
public class Motor {

    @Override
    public String toString() {
        return "1600C";
    }    
}