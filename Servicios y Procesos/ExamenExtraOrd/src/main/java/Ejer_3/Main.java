package Ejer_3;

import Ejer_3.Clases.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Persona pers1 = new Persona("Pepe", new Cuchillo(), new Tenedor());
        ArrayList<Alimento> listAlimentosOrdPrecio = new ArrayList<>(pers1.getListaAlimentos().keySet());
        //  Lista pre Orden
//        listAlimentosOrdPrecio.forEach(x -> System.out.println(x + "->" + x.getPrecio()));
//        System.out.println("-----------------------------");

        //  Instancia anónima para la ordenación por precio
        Collections.sort(listAlimentosOrdPrecio, new Comparator<Alimento>() {
            @Override
            public int compare(Alimento p1, Alimento p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        });
        //  Lista ya ordenada por precio
        System.out.println("**************** ORDEN POR PRECIO ****************");
        listAlimentosOrdPrecio.forEach(x -> System.out.println(x + " -> precio: " + x.getPrecio() + " -> calorias:" + x.getCalorias()));

        try {
            double[] caloPrec = pers1.comer(listAlimentosOrdPrecio, pers1.getCuchillo(), pers1.getTenedor());

            System.out.println("\nPrecio total: " + caloPrec[0]);
            System.out.println("Calorias total: " + caloPrec[1]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Comprobamos que las calorias y el gasto esten en los atributos de la persona

        System.out.println(pers1);
    }
}
