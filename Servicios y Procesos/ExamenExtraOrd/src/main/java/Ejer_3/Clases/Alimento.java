package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;
import Ejer_3.Interfaces.NutricionPrecios;

public abstract class Alimento implements NutricionCalorias, NutricionPrecios, Comparable<Alimento> {
    protected double precio;
    protected double calorias;

    public double getPrecio() {
        return precio;
    }

    public double getCalorias() {
        return calorias;
    }

    @Override
    public int compareTo(Alimento o) {
        return this.getClass().getSuperclass().getSimpleName().compareTo(o.getClass().getSuperclass().getSimpleName());
    }
}
