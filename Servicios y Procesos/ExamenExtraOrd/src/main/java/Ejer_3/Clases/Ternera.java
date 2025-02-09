package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;
import Ejer_3.Interfaces.NutricionPrecios;

public class Ternera extends Carne{
    public Ternera() {
        this.calorias = NutricionCalorias.TERNERA;
        this.precio = NutricionPrecios.TERNERA;
    }

    @Override
    public double digerir() {
        return calorias;
    }

    @Override
    public String toString() {
        return "Ternera";
    }
}
