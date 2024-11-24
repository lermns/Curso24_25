// Crear la clase Carta en base a la familia y el parentesco. Se dispone de un
// constructor parametrizado y la sobrescritura del método toString.


package p0;

public class Carta {

    private Familias familia;
    private Parentesco parentesco;

    public Carta(Familias familia, Parentesco parentesco) {
        this.familia = familia;
        this.parentesco = parentesco;
    }

    @Override
    public String toString() {
        return "[" + familia + ", " + parentesco + "]";
    }
}