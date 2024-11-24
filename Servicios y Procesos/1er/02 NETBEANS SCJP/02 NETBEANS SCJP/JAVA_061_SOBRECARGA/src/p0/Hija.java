// Crear una clase Hija que herede de la clase Madre y combine sobrescritura y
// sobrecarga con respecto al método saludar definido en la madre.


package p0;

public class Hija extends MadreSobrecarga {
    
    // SOBRECARGA : DOS O MÁS MÉTODOS CON EL MISMO NOMBRE (VIGILAR LOS HEREDADOS VISIBLES).
    // SOBRESCRITURA : REDEFINICIÓN DE LA HERENCIA (VISIBLE) .
    
    // SOBRESCRITURA Y SOBRECARGA SIMULTÁNEAMENTE:
    // Sobrecribimos el método heredado y sobrecargamos el método de más abajo (sólo en hija).
    @Override       
    public void saludar() {
        System.out.println("HOLA COMO ESTAS");
    }    
    
    // SÓLO SOBRECARGA:
    // Línea de parámetros distinta al método anterior.
    // Este método sobrecarga a la versión que no pide ningún parámetro (heredada y propia, ambas las ve).
    private void saludar(String nombre) {
        System.out.println("HOLA " + nombre);
    }   
}