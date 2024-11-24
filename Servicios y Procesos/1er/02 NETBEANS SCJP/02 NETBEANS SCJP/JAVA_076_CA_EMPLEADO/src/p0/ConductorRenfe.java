// Crear la clase ConductorRenfe que extiende a Empleado. Inicializar los atributos e
// implementar el total de métodos abstractos en base a su comportamiento en la vida real.


package p0;

public class ConductorRenfe extends Empleado {

    public ConductorRenfe(String nombre, int edad, int numeroSS) {
        // LA NÓMINA LA ASIGNAMOS DIRECTAMENTE POR "HARD CODDING" ... sólo para el ejemplo.        
        super(nombre, edad, 45000, numeroSS);
    }  
    
    @Override
    protected void trabajar() {
        System.out.println("EL CONDUCTOR DE RENFE LLEVA EL TREN");
    }

    @Override
    protected void descansar() {
        System.out.println("EL CONDUCTOR TIENE MUCHOS TIEMPOS DE DESCANSO");
    }    
}