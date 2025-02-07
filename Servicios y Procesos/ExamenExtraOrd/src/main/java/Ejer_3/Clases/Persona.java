package Ejer_3.Clases;

import java.util.TreeMap;

public class Persona {
    private String nombre;
    private static int id;
    private TreeMap<String, Alimento> listaAlimentos;
    private Cuchillo cuchillo;
    private Tenedor tenedor;
    private int caloriasIngeridas;
    private int gasto;

    public Persona(String nombre, Cuchillo cuchillo, Tenedor tenedor) {
        listaAlimentos = ordenar();
        this.nombre = nombre;
        this.cuchillo = cuchillo;
        this.tenedor = tenedor;
        id++;
    }

    public Persona(String nombre) {
        listaAlimentos = ordenar();
        this.nombre = nombre;
        id++;
    }

    private TreeMap<String ,Alimento> ordenar(){
        return new TreeMap<>();
    }
}

