package Ejer_3.Clases;

import Ejer_3.Interfaces.NutricionCalorias;

public class Emperador extends Pescado {
    public Emperador() {
        this.calorias = NutricionCalorias.EMPERADOR;
        this.precio = NutricionCalorias.EMPERADOR;
    }

    @Override
    public int digerir() {
        return 0;
    }

}
