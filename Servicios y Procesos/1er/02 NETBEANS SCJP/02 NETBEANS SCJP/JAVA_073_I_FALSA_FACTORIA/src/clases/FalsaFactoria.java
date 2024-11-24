// Crear la clase abstracta que constituya la factoria de objetos de ClaseImplementacion,
// pero manejados éstos en base a una de las 3 interfaces declaradas (I1 .. I3).

// Las interfaces son públicas, la clase de implementación es de paquete, y sólo
// se puede hacer uso de ella a través de la falsa factoria pública, la cúal,
// devolverá una referencia o manejador de tipo interfaz, y núnca de la propia
// clase. Así, conseguimos DESACOPLAMIENTO entre la clase de implementación y el
// cliente de la misma, algo sumamente beneficioso y recomendable (podemos además
// establecer privilegios de uso en función del cliente que quiera emplearla, ya
// que los métodos a utilizar se determinarán en base al tipo de interfaz devuelta).


package clases;

import interfaces.I1;
import interfaces.I2;
import interfaces.I3;

public abstract class FalsaFactoria { // clase abstracta con métodos estáticos.
    
    public static I1 obtenerI1() {
        // Se demuestra como una instancia de ClaseImplementacion cumple la regla
        // IS-A con respecto a la interfaz I1 (igual con I2 e I3).
        //System.out.println("A es instancia de I1 ... " + ((a instanceof I1)?"SI":"FALSE"));
        
        // Devolvemos el objeto visto como la referencia (sólo se puede usar m1()).
        return new ClaseImplementacion();
    }

    public static I2 obtenerI2() {
        return new ClaseImplementacion();
    }
        
    public static I3 obtenerI3() {
        return new ClaseImplementacion();
    }    
}