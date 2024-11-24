// Crear la clase abstracta Animal como punto de inicio en la jerarquía de
// clases. Sobrescribir el método toString para dar el nombre de la clase.


package animales;

public abstract class Animal {

    @Override
    public String toString() {
        return getClass().getSimpleName().toUpperCase();
    }   
}