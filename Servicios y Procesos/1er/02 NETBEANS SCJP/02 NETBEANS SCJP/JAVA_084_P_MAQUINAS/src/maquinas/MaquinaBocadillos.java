// Crear la subclase MaquinaBocadillos, implementando los métodos abstractos de
// Maquina. La determinación de cuántos lotes se han de fabricar se establecerá
// a través del encadenamiento de los constructores de las clases. Generar un 
// método propietario a ser empleado por el servicio técnico, pruebaPan().


package maquinas;

import interfaces.InterfazPrecios;

public class MaquinaBocadillos extends Maquina {

    public MaquinaBocadillos(int cuantosLotes) {
        super(cuantosLotes);
    }    
    
    @Override
    public void reparar() {
        System.out.println("SE CAMBIAN LAS POLEAS");
        System.out.println("SE LIMPIA LA MAQUINA");
    }

    @Override
    protected void informeProductividad() {
        super.informeProductividad();
        productividad = cuantosLotes * InterfazPrecios.BENEFICIO_MB;
        System.out.println("BENEFICIO BRUTO = " + productividad);
        productividad -= costeReparacion;
        System.out.println("BENEFICIO NETO = " + productividad);        
    }

    public void pruebaPan() {
        System.out.println("SE CARGA LA MAQUINA CON PAN");
    }
}