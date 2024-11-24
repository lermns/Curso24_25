// Realizar el mismo proceso con el componente Procesadores que ya se hizo con Cajas.

// INTEL_I7(300), PHENOM(270).


package enumerados;

public enum Procesadores {

    INTEL_I7(300), PHENOM(270);
    
    private int precio;
    
    private Procesadores(int precio) {
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