// Crear la clase ComparadorTitulo que implementa la interfaz Comparator,
// para realizar una ordenación por titulo


package comparadores;

import dvds.DVD;
import java.util.Comparator;

public class ComparadorTitulo implements Comparator<DVD> {

    @Override
    public int compare(DVD dvd1, DVD dvd2) {
        return dvd1.getTitulo().compareTo(dvd2.getTitulo());
    }
}