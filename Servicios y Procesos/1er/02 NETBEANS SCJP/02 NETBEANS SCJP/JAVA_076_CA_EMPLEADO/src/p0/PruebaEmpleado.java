// Crear objetos Persona, ConductorRenfe y Fontanero para comprobar su comportamiento.
// Utilizar supertipo Empleado cuando sea posible.


package p0;

public class PruebaEmpleado {

    public static void main(String[] args) {
        
        Persona juan = new Persona("JUAN", 35);
        System.out.println(juan);
        
        System.out.println("\n____________________________\n");

        // LAS NÓMINAS SE ASIGNAN DIRECTAMENTE EN LOS CONSTRUCTORES.
        
        Empleado pepe = new Fontanero("PEPE", 42, 1112222);
        System.out.println(pepe);
        
        System.out.println("\n____________________________\n");

        Empleado ana = new ConductorRenfe("ANA", 24, 123456);
        System.out.println(ana);        
    }
}