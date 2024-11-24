// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// protected.


package p1;

import p0.Madre;

public class Hija2 extends Madre {
    
    // Hija2(paquete p1) ESTÁ HEREDANDO #dinero DE SU MADRE(paquete p0).
    // SI LA CLASE HEREDERA DEFINIESE SU PROPIA VARIABLE dinero, ÉSTA OCULTARÍA
    // A LA HEREDADA DE LA MADRE, SIENDO SU PAQUETE DE DEFINICIÓN ORIGINAL p1,
    // CON LO QUE UNA CLASE INTRUSO ACCEDERÍA A DICHA VARIABLE CREADA EN LA HIJA,
    // MANTENIÉNDOSE LA HEREDADA COMO NO ACCESIBLE.
    // int dinero = -10000;
    
    String direccion = "c/ Alemania 46 1D"; // atributo definido en la hija (paquete p1).
    
    // SI NO SE HA CREADO LA VARIABLE dinero EN LA CLASE HIJA, SÓLO SE TENDRÁ LA HEREDADA
    // DE LA MADRE, CON LO QUE LOS SIGUIENTE MÉTODOS ACCEDERÍAN POR IGUAL A DICHA VARIABLE.
    // SÓLO CUÁNDO SE DISPONE DE 2 VARIABLES dinero (HEREDADA+PROPIA) SE OBSERVA LA DIFERENCIA.
    public int obtenerDinero() {
        return dinero;
    }

    int obtenerDineroThis() {
        return this.dinero;
    }
    
    protected int obtenerDineroSuper() {
        return super.dinero;
    }
    
    public static void main(String[] args) {
        
        Madre madre = new Madre();
        
        // ERROR (NO PUEDO ACCEDER AL ATRIBUTO PROTEGIDO DE LA MADRE A TRAVÉS DE
        // UNA INSTANCIA DE ÉSTA YA QUE NO ESTAMOS EN EL MISMO PAQUETE DE LA MADRE):
        //System.out.println("HIJA2 --> DINERO DE MADRE = " + madre.dinero);        
        
        // ... PERO SÍ A TRAVÉS DE UNA INSTANCIA DE LA HIJA (NO IMPORTA EL PAQUETE):
        Hija2 hija2 = new Hija2();
        System.out.println("HIJA2 --> DINERO DE MADRE = " + hija2.dinero);   
    }   
}