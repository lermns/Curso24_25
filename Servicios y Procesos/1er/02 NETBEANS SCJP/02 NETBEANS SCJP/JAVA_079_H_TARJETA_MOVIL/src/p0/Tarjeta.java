// Crear una clase abstracta Tarjeta que defina un atributo protegido saldo. Se dotará
// a la clase de los métodos gastar(abstracto ya que cada subclase impondrá su versión
// del código), asignar (definido y final, de modo que el saldo pueda ser repuesto) y
// consultar(definido y final, para ver el saldo disponible). El saldo inicial es de 100.

// Nota: recordar que los métodos finales son en principio visibles por herencia (ver
// encapsulación) pero NO pueden sobrescribirse. Se busca así que todas las subclases
// utilicen la misma versión del método definida en la clase madre.


package p0;

public abstract class Tarjeta {

    protected int saldo;
    
    public Tarjeta() {
        saldo = 100;        
    }
    
    protected abstract void gastar(int cantidad);

    // No puede ser sobrescrito a pesar de que se hereda y es visible por las hijas.
    // Modificador final aplicado al método.
    protected final void asignar(int cantidad) {
        saldo += cantidad;
    }
    
    // Otro método final.
    protected final void consultar() {
        String tipo = getClass().getSimpleName().toUpperCase();
        System.out.println("EL SALDO ACTUAL DE TU " + tipo +" ES DE " + saldo + " €");
    }
}