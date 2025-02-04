package AyudaEmms.ejercicio_6;

public class Empleado {
    protected String nombre;
    protected int edad;
    protected double porcentajeSueldoIncrem;
    protected double sueldoBase;
    protected final String empresaNom="Eléctrica SA";
    public String as;

    public Empleado(String nombre, int edad, double porcentajeSueldoIncrem) {
        this.nombre = nombre;
        this.edad = edad;
        this.porcentajeSueldoIncrem = porcentajeSueldoIncrem;
        this.sueldoBase = (10*porcentajeSueldoIncrem)+1000;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = ((sueldoBase/100)*porcentajeSueldoIncrem)+sueldoBase;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", porcentajeSueldoIncrem=" + porcentajeSueldoIncrem +
                ", sueldoBase=" + sueldoBase +
                ", empresaNom='" + empresaNom + '\'' +
                '}';
    }
}
