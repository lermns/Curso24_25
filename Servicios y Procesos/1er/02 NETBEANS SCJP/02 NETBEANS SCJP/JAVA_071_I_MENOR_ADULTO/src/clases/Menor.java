// Crear la implementación de la interfaz del menor. Establecer como atributo protegido
// una instancia de la variable tienda, que inicializaremos a través del constructor.


package clases;

import interfaces.InterfazMenor;

public class Menor implements InterfazMenor {

    protected Tienda tienda;
    
    public Menor(Tienda tienda) {
        this.tienda = tienda;
    }   
    
    @Override
    public void comprarGolosinas(int cuantas) {
        tienda.comprarGolosinas(cuantas);
    }
}