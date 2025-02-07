package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;

public class Sushi extends Pescado{
    public Sushi() {
        this.calorias = NutricionCalorias.SUSHI;
        this.precio = NutricionCalorias.SUSHI;
    }

    @Override
    public int digerir() {
        return 0;
    }

}
