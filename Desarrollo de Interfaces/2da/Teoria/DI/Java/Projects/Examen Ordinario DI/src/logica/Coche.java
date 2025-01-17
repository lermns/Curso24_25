
package logica;

import java.util.ArrayList;

/**
 *
 * @author PedroBorreganBurgos
 */

public class Coche {
   public static final ArrayList<Coche> COCHES = new ArrayList<>();
    
    private String marca, transmision, combustible;
    private int fechaMatriculacion, kilometros, color;

    public Coche(String marca, int fechaMatriculacion, int kilometros, int color, String transmision, String combustible) {
        this.marca = marca;
        this.fechaMatriculacion = fechaMatriculacion;
        this.kilometros = kilometros;
        this.color = color;
        this.transmision = transmision;
        this.combustible = combustible;
    }
    
    public String getMarca() {
        return marca;
    }

    public String getTransmision() {
        return transmision;
    }

    public String getCombustible() {
        return combustible;
    }

    public int getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public int getKilometros() {
        return kilometros;
    }

    public int getColor() {
        return color;
    }

}
