// Realizar el mismo proceso con el componente PlacasBase que ya se hizo con Cajas.

// ASROCK(190), ASUS_P6(220).


package enumerados;

public enum PlacasBase {

    ASROCK(190), ASUS_P6(220);
    
    private int precio;
    
    private PlacasBase(int precio) {
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