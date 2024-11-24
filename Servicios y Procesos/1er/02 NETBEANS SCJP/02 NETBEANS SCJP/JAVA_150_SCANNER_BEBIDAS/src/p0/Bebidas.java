// Crear un tipo enumerado que defina distintas bebidas y su precio. Añadir
// los métodos getter correspondientes para poder consultar el precio y el
// nombre de la bebida elegida. Sobrescribir el método toString.


package p0;


public enum Bebidas {

    COCACOLA(1.30),
    AGUA(0.60),
    CAFE(1.00);
    
    private double precio;
    
    private Bebidas(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getNombre() {
        return name();
    }
        
    @Override
    public String toString() {
        return name() + " ---> " + precio + " €";
    }   

}