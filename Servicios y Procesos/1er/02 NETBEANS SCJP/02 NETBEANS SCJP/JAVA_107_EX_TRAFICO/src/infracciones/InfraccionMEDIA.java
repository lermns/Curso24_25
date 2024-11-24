// Crear InfraccionMEDIA cómo subclase de InfraccionGRAVE.
// Granularidad media.


package infracciones;

public class InfraccionMEDIA extends InfraccionGRAVE {
    
    protected InfraccionMEDIA(String descripcion, int puntosARestar, int multa) {
        super(descripcion, puntosARestar, multa);
    }

    public InfraccionMEDIA() {
        this("SIN CINTURON DE SEGURIDAD", 5, 300);
    }    
}