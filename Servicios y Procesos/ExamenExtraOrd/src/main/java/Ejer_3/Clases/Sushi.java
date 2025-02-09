package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;
import Ejer_3.Interfaces.NutricionPrecios;

public class Sushi extends Pescado{
    public Sushi() {
        this.calorias = NutricionCalorias.SUSHI;
        this.precio = NutricionPrecios.SUSHI;
    }

    @Override
    public double digerir() {
        return calorias;
    }

    @Override
    public String toString() {
        return "Sushi";
    }
}
