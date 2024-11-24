// Realizar el mismo proceso con el componente Memorias que ya se hizo con Cajas.

// SKILL_16GB(90), KINGSTONE_32GB(170).


package enumerados;

public enum Memorias {

    SKILL_16GB(90), KINGSTONE_32GB(170);
    
    private int precio;
    
    private Memorias(int precio) {
        this.precio = precio;
    }
    
    public int cosultarPrecio() {
        return precio;
    }
        
    @Override
    public String toString() {
        return name() + " _ " + precio;
    }   
}