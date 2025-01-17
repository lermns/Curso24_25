package exrec.logica;

import java.util.ArrayList;

public class Viaje {
   public static final ArrayList<Viaje> COCHES = new ArrayList<>();
    
    private String marca, transmision, combustible;
    private int fechaMatriculacion, kilometros, color;

    public Viaje(String marca, int fechaMatriculacion, int kilometros, int color, String transmision, String combustible) {
        this.marca = marca;
        this.fechaMatriculacion = fechaMatriculacion;
        this.kilometros = kilometros;
        this.color = color;
        this.transmision = transmision;
        this.combustible = combustible;
    }

}
