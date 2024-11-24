// La clase Dedo. En esta ocasión, no se crea el anillo por cada dedo sino que se
// dispone de un método que asignará el anillo pasado por referencia.


package p0;

public class Dedo {

    private String nombre;
    private int posicion;
    private Anillo anillo;
        
    public Dedo(String nombre, int posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }
    
    public String obtenerNombreDedo() {
        return nombre;
    }
    
    public void asignarAnillo(Anillo anillo) {
        this.anillo = anillo;
    }
        
    @Override
    public String toString() {
        
        String texto = nombre + " - " + posicion;

        if(anillo != null) {
            return texto + " - " + anillo.toString();
        }
        
        return texto;        
    }   
}