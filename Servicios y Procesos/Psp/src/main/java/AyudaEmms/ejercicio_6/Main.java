package AyudaEmms.ejercicio_6;

public class Main {
    public static void main(String[] args) {
        Empleado emp1 = new Empleado("pepe", 25, 10);
        Jefe jef1 = new Jefe("Alonso", 35, 20, "DevOps");

        System.out.println(emp1);
        System.out.println(jef1);

        emp1.setSueldoBase(1200);
        jef1.setPlusSueldo(300);

        System.out.println(emp1);
        System.out.println(jef1);

        emp1.setSueldoBase(1300);
        jef1.setPlusSueldo(400);
        jef1.setSueldoBase(1200);

        System.out.println(emp1);
        System.out.println(jef1);
    }
}
