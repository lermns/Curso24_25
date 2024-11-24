// Crear la clase SiVolador para definir el comportamiento de las subclases de Pato
// que SÍ vuelen.


package p0;

public class SiVolador extends Volador {

    @Override
    public void volar() {
        System.out.println("... VUELA \n");       
    }    
}