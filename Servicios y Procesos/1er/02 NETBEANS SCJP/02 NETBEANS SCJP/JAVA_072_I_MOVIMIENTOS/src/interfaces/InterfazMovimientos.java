// Crear una interfaz que declare los movimientos básicos (no se pide ningún parámetro
// de entrada), además de un movimiento compuesto por dos parámetros x e y, que indicarán
// una posición final en un plano.

// Movimientos básicos: arriba, abajo, derecha, izquierda.

package interfaces;


public interface InterfazMovimientos {

    // public abstract
    
    public void moverDerecha();
    
    public void moverIzquierda();
    
    public void moverArriba();
    
    public void moverAbajo();
    
    public void mover(int posFinalX, int posFinalY);
}