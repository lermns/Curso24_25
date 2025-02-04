package AyudaEmms.ejercicio_6;

public class Jefe extends Empleado{
    private double plusSueldo = 250;
    private final String DEP_RESPONSABLE;

    public Jefe(String nombre, int edad, double porcentajeSueldoIncrem, String depResponable) {
        super(nombre, edad, porcentajeSueldoIncrem);
        this.DEP_RESPONSABLE = depResponable;
        this.sueldoBase += sueldoPorcetaje();
    }

    public void setPlusSueldo(double plusSueldo) {
        this.sueldoBase -= sueldoPorcetaje();
        this.plusSueldo = plusSueldo;
        this.sueldoBase += sueldoPorcetaje();
    }

    @Override
    public void setSueldoBase(double sueldoBase) {
        super.setSueldoBase(sueldoBase+plusSueldo);
    }

    private double sueldoPorcetaje(){
        return ((plusSueldo/100)*porcentajeSueldoIncrem) + plusSueldo;
    }

    @Override
    public String toString() {
        return "Jefe{" + ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", porcentajeSueldoIncrem=" + porcentajeSueldoIncrem +
                ", sueldoBase=" + sueldoBase +
                ", empresaNom='" + empresaNom + '\'' +
                "plusSueldo=" + plusSueldo + '\'' +
                ", depResponable='" + DEP_RESPONSABLE + '\'' +
                '}';
    }
}
