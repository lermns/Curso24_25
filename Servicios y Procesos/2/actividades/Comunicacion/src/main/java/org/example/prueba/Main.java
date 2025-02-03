package org.example.prueba;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<C2> c2List = new ArrayList<>();
        ArrayList<D1> d1List = new ArrayList<>();
        ArrayList<E2> e2List = new ArrayList<>();

        altaPersonas(c2List);
        altaPersonas(d1List);
        altaPersonas(e2List);

        altaPersonas2(c2List);
        altaPersonas2(d1List);
        //altaPersonas2(e2List);
    }

    public static void altaPersonas(ArrayList<? extends C2> persona){
        persona.forEach(System.out::println);
    }

    public static void altaPersonas2(ArrayList<? super D1> persona){
        persona.forEach(System.out::println);
    }
}
