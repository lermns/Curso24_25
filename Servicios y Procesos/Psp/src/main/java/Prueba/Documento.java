package Prueba;

import java.io.Serializable;

public class Documento implements Serializable {
    private final String nombre;
    private final String ruta;
    private final String tipoExt;

    public Documento(String nombre, String ruta, String tipoExt) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.tipoExt = tipoExt;
    }

    @Override
    public String toString() {
        return "Prueba.Documento{" + "nombre='" + nombre + '\'' +
                ", ruta='" + ruta + '\'' +
                ", tipo='" + tipoExt + '\'' +
                '}';
    }
}
