package ejercicio_18;

public class Vehiculo {
    private final String marca;
    private final String modelo;
    private final String color;
    private final int annio;
    private final boolean metalizado;

    public Vehiculo(String marca, String modelo, String color, int annio, boolean metalizado) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.annio = annio;
        this.metalizado = metalizado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", annio=" + annio +
                ", metalizado=" + metalizado +
                '}';
    }
}
