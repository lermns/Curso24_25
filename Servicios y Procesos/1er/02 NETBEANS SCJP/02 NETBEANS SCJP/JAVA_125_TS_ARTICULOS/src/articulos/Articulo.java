// Crear la clase abstracta Articulo como punto de incio de la jerarquía de
// clases, haciendo que implemente la interfaz Comparable la cuál, se marcará
// con el género <Articulo>. Definir en la clase los atributos precio y nombre.
// Implementar el método compareTo para realizar una ordenación natural por
// precio, de forma ascendente (y opcionalmente probar la descendente).


package articulos;


// MARCAMOS LA INTERFAZ COMPARABLE CON GENERO (ALT + INSERTAR)
// TODAS LAS CLASES HIJAS SERÁN Comparable POR HERENCIA (implementación indirecta).
public abstract class Articulo implements Comparable<Articulo> {

    protected int precio;
    protected String nombre;
    
    protected Articulo(int precio) {
        this.precio = precio;
        this.nombre = getClass().getSimpleName().toUpperCase();
    }
    
    
    // SOBRESCRIBIMOS EL MÉTODO DE COMPARACIÓN EN LA CLASE MADRE. ASÍ, EL
    // CÓMO SE ORDENARÁN LOS ELEMENTOS, SERÁ LO MISMO PARA TODAS LAS SUBCLASES.
    @Override
    public int compareTo(Articulo articulo) { // ya no aparece Object.
        return precio - articulo.precio;    // ascendente (YO - TÚ).
        //return articulo.precio - precio;  // descendente (TÚ - YO).
    }        
    
    @Override
    public String toString() {
        return nombre + "..." + precio;
    }
    
}