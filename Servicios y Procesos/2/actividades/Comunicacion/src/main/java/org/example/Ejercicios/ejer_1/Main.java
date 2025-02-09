package org.example.Ejercicios.ejer_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * El cliente (Profe) pilla los alumnos que hay en un fichero (notasAlumnos.dat),
 * luego se los manda al servidor para que el servidor
 * filtre a los alumnos que tienen mas de un 5 y que los guarde en un fichero llamado Aprobados.txt
 * y luego le mande una connfirmacion al cliente.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> listaAlunmos= new ArrayList<>();
        listaAlunmos.add("Pepe 7");
        listaAlunmos.add("Sofia 10");
        listaAlunmos.add("Alan 5");
        listaAlunmos.add("Juan 8");

        for (String s : listaAlunmos){
            byte[] arry = s.getBytes();
            for (int i = 0; i < arry.length; i++) {
                System.out.print(arry[i] + "-");
            }
            System.out.println("sep");
        }
    }

    private static void escribir(){

        try(BufferedOutputStream bfo = new BufferedOutputStream(new FileOutputStream("src/main/java/org/example/Ejercicios/ejer_1/notasAlumnos.dat"))){

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero...!");
        }
    }
}
