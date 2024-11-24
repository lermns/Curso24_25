// Crear el tipo enumerado Cajas utilizando los valores THERMALTAKE y LIAN, de 
// modo que cada uno ellos invoque al constructor del tipo para designar el
// precio de la caja utilizada. Así, se dispone de un constructor parametriza
// que actuará sobre la variable privada precio, pudiendo ser ésta consultada
// a través de un método público consultarPrecio(a modo de getter). Se realiza
// la sobrescritura del método toString para informar sobre la caja.

// THERMALTAKE(250), LIAN(280). Observar el paso de parámetros al método.


package enumerados;

public enum Cajas {

    THERMALTAKE(250), LIAN(280);
    
    private int precio;
    
    private Cajas(int precio) {
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