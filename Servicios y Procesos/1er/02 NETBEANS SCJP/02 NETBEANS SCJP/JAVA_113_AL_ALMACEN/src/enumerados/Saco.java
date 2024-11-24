// Crear el tipo enumerado para constituir los distintos tipos de sacos que se
// pueden manejar en la clase Almacen. Cada saco dispone de un precio y peso,
// valores privados que requerirán de su método de consulta correspondiente. Se
// sobrescribe el método toString para dar información sobre el saco.

// Nota: Recordar que los valores del enumerado representan instancias ÚNICAS.
//       Así, sólo existirá 1 objeto de ARROZ, otro de TRIGO y otro de MAIZ, y
//       que los cambios que pueda hacer un cliente sobre, por ejemplo, ARROZ,
//       afectarán por igual a cualquier otro cliente de ARROZ.


package enumerados;

public enum Saco {

    // NOMBRE (PRECIO - PESO).
    ARROZ(120,500), 
    TRIGO(250,400),
    MAIZ(500,600);
    
    
    private int precio;
    private int peso;
    
    private Saco(int precio, int peso) {
        this.precio = precio;
        this.peso = peso;
    }
    
    public int obtenerPrecio() {
        return precio;
    }

    public int obtenerPeso() {
        return peso;
    }
    
    
    @Override
    public String toString() {
        return name() + " ... " + precio + " € ... " + peso + " Kg";
    }    
    
}