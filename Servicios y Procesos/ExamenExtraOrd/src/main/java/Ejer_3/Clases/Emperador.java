package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;
import Ejer_3.Interfaces.NutricionPrecios;

public class Emperador extends Pescado {
    public Emperador() {
        this.calorias = NutricionCalorias.EMPERADOR;
        this.precio = NutricionPrecios.EMPERADOR;
    }

    @Override
    public double digerir() {
        return calorias;
    }

    @Override
    public String toString() {
        return "Emperador";
    }
}
