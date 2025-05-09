package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;
import Ejer_3.Interfaces.NutricionPrecios;

public class Cerdo extends Carne{
    public Cerdo() {
        this.calorias = NutricionCalorias.CERDO;
        this.precio = NutricionPrecios.CERDO;
    }

    @Override
    public double digerir() {
        return calorias;
    }

    @Override
    public String toString() {
        return "Cerdo";
    }
}
