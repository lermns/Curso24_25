// Crear la clase abstracta Empleado que extenderá a la clase Persona. Se definirán los
// atributos nomina y numeroSS (Seguridad Social) junto con un constructor parametrizado
// que inicialice el total de atributos (los propios y los heredados de Persona). Se
// vuelve a sobrescribir el método toString y se añaden 2 métodos abstractos denominados
// trabajar y descansar. Esta clase constituye el punto de inicio de la jerarquía de clases
// de tipo Empleado.


package p0;

// Herencia de una clase abstracta (no completa, inacabada) sobre una no abstracta.
public abstract class Empleado extends Persona {

    protected int nomina;
    protected int numeroSS;
    
    protected Empleado(String nombre, int edad, int nomina, int numeroSS) {
        super(nombre, edad);
        this.nomina = nomina;
        this.numeroSS = numeroSS;
    }

    protected abstract void trabajar();
    
    protected abstract void descansar(); 
    
    @Override
    public String toString() {
        return super.toString() + ", NOMINA = " + nomina + ", NUMERO_SS = " + numeroSS;        
    }   
}