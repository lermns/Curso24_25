// Crear la clase NoVolador para definir el comportamiento de las subclases de Pato
// que NO vuelen.


package p0;

public class NoVolador extends Volador {

    @Override
    public void volar() {
        System.out.println("... NO VUELA \n");       
    }    
}
