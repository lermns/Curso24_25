package Ejer_3.Clases;

import java.util.TreeMap;

public abstract class Carne extends Alimento{
    @Override
    public final void masticar() {
        System.out.print("Ñam Ñam, qué rico está la Carne de ");
    }

    @Override
    public String toString() {
        return "Carne";
    }
}

