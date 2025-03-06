package org.example.Encriptacion.Pruebas.prueba3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "hola que tal";
        byte[] arryBytes = s.getBytes();
        System.out.println(Arrays.toString(arryBytes));
        System.out.println(new String(arryBytes));
    }
}
