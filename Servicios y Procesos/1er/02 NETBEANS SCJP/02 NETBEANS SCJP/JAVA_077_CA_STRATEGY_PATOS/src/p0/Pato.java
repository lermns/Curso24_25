// Crear la clase abstracta Pato como inicio de jerarquía de las subclases PatoGoma y
// PatoReal. En ella, definir un atributo de tipo Volador para encapsular el futuro
// comportamiento volar (composición).


package p0;

public abstract class Pato implements InterfazMetodosPato {

    // Encapsulamos el comportamiento que varía en una variable de tipo Volador.
    private Volador volador;
    
    // Cada subclase de Pato elegirá aquél comportamiento que más le interese.
    public Pato(Volador volador) {
        this.volador = volador;
    }
    
    @Override
    public void volar() {
        // La clase abstracta Pato cumple con el contrato de la interfaz.
        System.out.print("El pato del tipo:  " + getClass().getSimpleName().toUpperCase());
        volador.volar(); // delegación de funcionalidad al objeto de composición.
    }
}