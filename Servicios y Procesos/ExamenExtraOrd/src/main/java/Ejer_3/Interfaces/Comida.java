package Ejer_3.Interfaces;

import Ejer_3.Clases.Alimento;
import Ejer_3.Clases.Cuchillo;
import Ejer_3.Clases.Tenedor;

import java.util.ArrayList;

public interface Comida {
    double[] comer(ArrayList<Alimento> listaAlimentos, Cuchillo cuchillo, Tenedor tenedor) throws Exception;
}
