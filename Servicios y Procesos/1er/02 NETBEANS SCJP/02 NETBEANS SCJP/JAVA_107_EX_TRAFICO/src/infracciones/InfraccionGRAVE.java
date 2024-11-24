// Crear InfraccionGRAVE cómo subclase de la excepción personalizada Infracción.
// Granularidad gruesa (cuánto más arriba en la línea de herencia, más genérica).


package infracciones;

// ESTABLECEMOS UNA JERARQUÍA DE CLASES PARA LAS INFRACCIONES PERSONALIZADAS:
// Exception <- InfraccionGRAVE <-> InfraccionMEDIA <- InfraccionLEVE.

public class InfraccionGRAVE extends Infraccion {
    
    // nivel protegido para asegurar encadenamiento pero NO INSTANCIACIÓN
    // desde fuera del paquete.
    protected InfraccionGRAVE(String descripcion, int puntosARestar, int multa) {
        super(descripcion, puntosARestar, multa);
    }

    // nivel público, permitiéndose la instanciación. NO PEDIMOS NADA.
    // De haberse hecho pública la anterior, el usuario podría cambiar los
    // datos de la infracción. En caso de haberla dejado protected, no se 
    // podrían intanciar objetos infracción.
    public InfraccionGRAVE() {
        this("COMA ETILICO", 12, 1001);
    }    

}