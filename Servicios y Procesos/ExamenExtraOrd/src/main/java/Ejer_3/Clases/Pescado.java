package Ejer_3.Clases;

public abstract class Pescado extends Alimento{
    @Override
    public final void masticar() {
        System.out.print("Ñam Ñam, qué rico está el de Pescado ");
    }
    @Override
    public String toString() {
        return "Pescado";
    }
}

