// Crear la clase Fontanero que extiende a Empleado. Inicializar los atributos e
// implementar el total de métodos abstractos en base a su comportamiento en la
// vida real.


package p0;

public class Fontanero extends Empleado {

    public Fontanero(String nombre, int edad, int numeroSS) {
        // LA NÓMINA LA ASIGNAMOS DIRECTAMENTE POR "HARD CODDING" ... sólo para el ejemplo.
        super(nombre, edad, 30000, numeroSS);
    }
 
    @Override
    protected void trabajar() {
        System.out.println("EL FONTANERO REALIZA LA INSTALACION DE AGUA");
    }

    @Override
    protected void descansar() {
        System.out.println("EL FONTANERO SOLO PARA DURANTE LA HORA DE LA COMIDA");
    }
}