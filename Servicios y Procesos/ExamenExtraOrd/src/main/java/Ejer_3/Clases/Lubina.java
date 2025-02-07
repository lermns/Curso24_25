package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;

public class Lubina extends Pescado{
    public Lubina() {
        this.calorias = NutricionCalorias.LUBINA;
        this.precio = NutricionCalorias.LUBINA;
    }

    @Override
    public int digerir() {
        return 0;
    }

}
