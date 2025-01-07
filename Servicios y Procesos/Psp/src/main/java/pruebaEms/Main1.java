package pruebaEms;

import java.util.Scanner;

public class Main1 {
    private static Scanner scStr = new Scanner(System.in);

    public static void main(String[] args) {
        int cantidad;
        Scanner scInt = new Scanner(System.in);

        System.out.println("dame la cantidad de alumnos que tendra el array");
        cantidad = scInt.nextInt();

        String[] lista = new String[cantidad];

        //para llenar los nulos de string vacios, para que no de problemas de nullpointerExcep
        for (int i = 0; i < lista.length; i++) {
            lista[i] = "vacio";
        }

        agregar(lista);
        agregar(lista);
        agregar(lista);
        agregar(lista);

        listar(lista);

        posicionAlumno(lista);

        eliminarAlumn(lista);

        listar(lista);

        agregar(lista);
        listar(lista);
    }

    private static void agregar(String[] lista){
        boolean bandera=true;

        System.out.println("dame el nombre ");
        String nombre = scStr.nextLine();

        for (int i = 0; i < lista.length;i++) {
            if(lista[i].equals("vacio") && bandera){
                lista[i]=nombre;
                bandera =false;
            }
        }

        if (bandera){
            System.out.println("no se puede agregar más de " + lista.length + " alumnos");
        }
    }

    private static void listar(String[] lista){
        for (String s : lista) {
            System.out.println(s);
        }
    }

    private static void posicionAlumno(String[] lista){
        System.out.println("dame nombre del alumno que esta buscando: ");
        String nombre = scStr.nextLine();

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(nombre)){
                System.out.println("nombre encontrado en la posición " + (i+1));
                return;
            }
        }
    }

    private static void eliminarAlumn(String[] lista){
        System.out.println("dame el nombre del alumno que quieres eliminar: ");
        String nombre = scStr.nextLine();

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(nombre)){
                System.out.println("alumno " + lista[i] + " elimando");
                lista[i] = "vacio";
                return;
            }
        }
    }
}
