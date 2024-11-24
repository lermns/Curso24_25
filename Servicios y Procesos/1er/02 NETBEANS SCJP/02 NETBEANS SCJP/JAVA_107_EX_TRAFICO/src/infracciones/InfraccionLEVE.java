// Crear InfraccionMEDIA cómo subclase de InfraccionGRAVE.
// Granularidad fina (cuánto más abajo en la línea de herencia, más expecifica).


package infracciones;

public class InfraccionLEVE extends InfraccionMEDIA {

    protected InfraccionLEVE(String descripcion, int puntosARestar, int multa) {
        super(descripcion, puntosARestar, multa);
    }    
    
    public InfraccionLEVE() {
        this("SIN TRIANGULO", 2, 100);
    }
}