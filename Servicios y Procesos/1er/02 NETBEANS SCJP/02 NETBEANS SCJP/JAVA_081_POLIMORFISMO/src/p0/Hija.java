// Crear una subclase Hija de Madre, que defina su propio método estático
// cocinar (no hay sobrescritura pero debemos cumplir con sus reglas si hay
// visibilidad directa) y sobrescriba el método trabajar.


package p0;

public class Hija extends Madre {

    public static void cocinar() {
        System.out.println("LA HIJA COCINA");
    }
    
    @Override
    public void trabajar() {
        System.out.println("LA HIJA TRABAJA");
    }   
}