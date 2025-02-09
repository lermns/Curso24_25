package Ejer_3.Clases;

import Ejer_3.Interfaces.Comida;

import java.util.ArrayList;
import java.util.TreeMap;

public class Persona implements Comida {
    private String nombre;
    private static int id;
    private TreeMap<Alimento, String> listaAlimentos;
    private Cuchillo cuchillo;
    private Tenedor tenedor;
    private double caloriasIngeridas;
    private double gasto;

    public Persona(String nombre, Cuchillo cuchillo, Tenedor tenedor) {
        listaAlimentos = ordenar();
        this.nombre = nombre;
        this.cuchillo = cuchillo;
        this.tenedor = tenedor;
        id++;
    }

    public Persona(String nombre, Tenedor tenedor) {
        listaAlimentos = ordenar();
        this.nombre = nombre;
        this.tenedor = tenedor;
        id++;
    }

    public Persona(String nombre, Cuchillo cuchillo) {
        listaAlimentos = ordenar();
        this.nombre = nombre;
        this.cuchillo = cuchillo;
        id++;
    }

    public Persona(String nombre) {
        listaAlimentos = ordenar();
        this.nombre = nombre;
        id++;
    }

    private TreeMap<Alimento ,String> ordenar(){
        TreeMap<Alimento, String> lista = new TreeMap<>();
        int rand;

        for (int i = 0; i <5 ; i++) {
            rand = (int)((Math.random()*2)+1);
            if(rand ==1){
                rand = (int)((Math.random()*2)+1);
                Alimento alimento = rand==1?new Cerdo():new Ternera();
                lista.put(alimento, alimento.getClass().getSimpleName());
            }else{
                rand = (int)((Math.random()*3)+1);
                Alimento alimento = rand==1?new Lubina():rand==2?new Sushi():new Emperador();
                lista.put(alimento, alimento.getClass().getSimpleName());
            }
        }
        System.out.println("*********** Se han agregado un total de: " + lista.size() + " alimentos de manera aleatoria ************");
        return lista;
    }

    public TreeMap<Alimento, String> getListaAlimentos() {
        return listaAlimentos;
    }

    public Cuchillo getCuchillo() {
        return cuchillo;
    }

    public Tenedor getTenedor() {
        return tenedor;
    }

    @Override
    public double[] comer(ArrayList<Alimento> listaAlimentos, Cuchillo cuchillo, Tenedor tenedor) throws Exception {
        String notaError = cuchillo==null?tenedor==null?"Tenedor y Cuchillo":"Cuchillo":tenedor==null?"Tenedor":"";

        if (!notaError.isBlank()){
            throw new Exception("Falta " + notaError);
        }

        double precioTotal = listaAlimentos.stream().mapToDouble(Alimento::getPrecio).sum();
        double caloriasTotal = listaAlimentos.stream().mapToDouble(Alimento::getCalorias).sum();

        cuchillo.cortar();
        tenedor.pinchar();

        for (Alimento a : listaAlimentos){
            if (a.getClass().getSuperclass().getSimpleName().equals("Pescado")){
                System.out.println("Compruebo que no hay espinas porque soy un paranoico..!");
            }
            a.masticar();
            System.out.println(a);
            caloriasIngeridas += a.digerir();
        }
        gasto = precioTotal;

        return new double[]{precioTotal, caloriasTotal};
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre='" + nombre + '\'' +
                ", listaAlimentos=" + listaAlimentos +
                ", cuchillo=" + cuchillo +
                ", tenedor=" + tenedor +
                ", caloriasIngeridas=" + caloriasIngeridas +
                ", gasto=" + gasto +
                '}';
    }
}

