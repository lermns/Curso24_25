// Crear la clase Envase definiendo en ella las propiedades material y capacidad.
// Sobrescribir el método toString() para obtener el estado del objeto.


package p0;

public abstract class Envase {

    protected String    material;
    protected int       capacidad;

    @Override
    public String toString() {
        return material + " _ " + capacidad + " CL";
    }    
}