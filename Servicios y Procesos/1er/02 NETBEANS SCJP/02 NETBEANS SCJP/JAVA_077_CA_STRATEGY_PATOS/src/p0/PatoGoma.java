// Subclase PatoGoma cuyo comportamiento volar viene dado por la clase NoVolador.
// Se realiza una delegación de funcionalidad, para lo cual, en el encadenamiento
// de los constructores, la hija decide el comportamiento, que más tarde usará
// a través del método heredado desde la madre.


package p0;

public class PatoGoma extends Pato {

    public PatoGoma() {
        super(new NoVolador());
    }
}