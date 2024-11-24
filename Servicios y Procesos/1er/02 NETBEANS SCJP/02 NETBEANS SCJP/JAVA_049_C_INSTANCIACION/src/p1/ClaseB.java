// Crear una clase que compruebe el funcionamiento de la sobrecarga de constructores.


package p1;

public class ClaseB {

    // POR DEFECTO:
    public ClaseB() {}

    
    // PARAMETRIZADO CON PRIMITIVOS:    
    public ClaseB(int x) {}
    
    public ClaseB(int x, int y) {}
    
    public ClaseB(int x, double y) {}
    
    public ClaseB(double x, int y) {}
    
    
    // PARAMETRIZADO CON PRIMITIVOS Y LONGITUD VARIABLE:
    public ClaseB(int y, int ... x) {}    
    //public ClaseB(int ... x) {} // Si añado éste Y LO USO, me error de compilación por ambigüedad.
    
    
    // REFERENCIADOS:    
    public ClaseB(Integer x) {}
    
    public ClaseB(Object x) {}
    
    public ClaseB(String x) {}
    
    
    public static void main(String[] args) {
     
        // Pulsar [CTRL] + botón izquierdo del ratón sobre el constructor para que
        // NetBeans nos muestre cuál de ellos se está realmente utilizando.
        
        new ClaseB(5); // se llama al de int --> Integer --> Object --> int parám. variables.
        
        new ClaseB(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5); // para uso de parámetros variables.
    }
}