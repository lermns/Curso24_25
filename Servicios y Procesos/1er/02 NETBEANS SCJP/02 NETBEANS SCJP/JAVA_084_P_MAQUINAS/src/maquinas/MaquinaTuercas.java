// Crear la subclase MaquinaTuercas, implementando los métodos abstractos de
// Maquina. Generar un método propietario a ser empleado por el servicio técnico,
// pruebaMetal().


package maquinas;

import interfaces.InterfazPrecios;

public class MaquinaTuercas extends Maquina {

    public MaquinaTuercas(int cuantas) {
        super(cuantas);
    }    
    
    @Override
    public void reparar() {
        System.out.println("SE CAMBIAN LOS ENGRANAJES");
        System.out.println("SE ENGRASA LA MAQUINA");
    }

    @Override
    protected void informeProductividad() {
        super.informeProductividad();
        productividad = cuantosLotes * InterfazPrecios.BENEFICIO_MT;
        System.out.println("BENEFICIO BRUTO = " + productividad);
        productividad -= costeReparacion;
        System.out.println("BENEFICIO NETO = " + productividad);        
    }

    public void pruebaMetal() {
        System.out.println("SE CARGA LA MAQUINA CON METAL");
    }
}