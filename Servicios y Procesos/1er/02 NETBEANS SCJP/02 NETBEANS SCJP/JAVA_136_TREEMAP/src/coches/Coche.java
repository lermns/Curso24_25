// Crear la clase Coche con las propiedades modelo, fecha y precio. Se
// implementa la interfaz Comparable y se sobrescribe el método compareTo
// para que realice una ordenación ascendente utilizando el campo modelo.
// Se dispone del constructor parametrizado, los getters correspondientes
// y se sobrescribe el método toString para informar sobre el coche en
// cuestión.


package coches;


// Coche se puede comparar directamente por su atributo modelo (compareTo).
public class Coche implements Comparable<Coche> {

    private String  modelo;
    private int     fecha; // es el año.
    private int     precio;
    
    public Coche(String modelo, int fecha, int precio) {
        this.modelo     = modelo;
        this.fecha      = fecha;
        this.precio     = precio;
    }
    
    @Override
    public int compareTo(Coche coche) {
        // ORDEN ASCENDENTE ... se comparan una pareja de String.
        return modelo.compareTo(coche.modelo);
    }
    
    // GETTERS
    public int getFecha() {
        return fecha;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPrecio() {
        return precio;
    }        
    
    @Override
    public String toString() {
        String texto = "\n________________________________\n";
        texto += "MODELO = " + modelo + "\n";
        texto += "AÑO = " + fecha + "\n";
        texto += "PRECIO = " + precio + "\n";        
        texto += "\n________________________________\n";
        
        return texto;
    }       

}