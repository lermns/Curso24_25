package Ejer_3.Clases;

import java.util.TreeMap;

public abstract class Carne extends Alimento{
    public static void main(String[] args) {
        TreeMap<Alimento, String> listAlimentos = new TreeMap<>();

        Alimento Carne1 = new Ternera();
        Alimento Carne2 = new Cerdo();

        Alimento Pescado1 = new Lubina();
        Alimento Pescado2 = new Emperador();
        Alimento Pescado3 = new Sushi();

        listAlimentos.put(Pescado2, Pescado2.getClass().getSimpleName());
        listAlimentos.put(Pescado1, Pescado1.getClass().getSimpleName());

        listAlimentos.put(Carne2, Carne2.getClass().getSimpleName());
        listAlimentos.put(Carne1, Carne1.getClass().getSimpleName());

        listAlimentos.put(Pescado3, Pescado3.getClass().getSimpleName());

        listAlimentos.forEach((x,y) -> System.out.println(x + " -> " + y));

        System.out.println(Carne1.getClass().getSuperclass().getSimpleName());

    }
    @Override
    public final void masticar() {

    }
}

