// Crear la subclase de Ingrediente, SalsaBarbacoa.


package ingredientes;

import interfaces.InterfazPrecios;

public class SalsaBarbacoa extends Ingrediente {

    public SalsaBarbacoa() {
        super(InterfazPrecios.PRECIO_SALSA_BARBACOA);
    }   
}