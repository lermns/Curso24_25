package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;
import Ejer_3.Interfaces.NutricionPrecios;

public class Lubina extends Pescado{
    public Lubina() {
        this.calorias = NutricionCalorias.LUBINA;
        this.precio = NutricionPrecios.LUBINA;
    }

    @Override
    public double digerir() {
        return calorias;
    }

    @Override
    public String toString() {
        return "Lubina";
    }
}
