// Subclase PatoReal cuyo comportamiento volar viene dado por la clase SiVolador.
// Se realiza una delegación de funcionalidad.


package p0;

public class PatoReal extends Pato {
    
    public PatoReal() {
        super(new SiVolador());
    }    
}
