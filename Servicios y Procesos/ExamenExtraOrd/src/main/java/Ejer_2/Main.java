package Ejer_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scStr = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Set<Asignatura> listAsignaturas = new HashSet<>();
        int expediente, cod, nota;
        String name, ape;

        System.out.println("dame el expediente del alumno: ");
        expediente = scInt.nextInt();

        if ((int)(Math.log10(Math.abs(expediente))+1) != 8) {
            System.err.println("Error con la cantidad de digitos en expediente");
            System.exit(0);
        }

        System.out.println("Dame el nombre: ");
        name = scStr.nextLine();
        System.out.println("Dame el apellido: ");
        ape = scStr.nextLine();

        for (int i = 0; i < 6; ) {
            System.out.println("dame el codigo de la asignatura: ");
            cod = scInt.nextInt();
            System.out.println("dame la nota de la asignatura");
            nota = scInt.nextInt();
            Asignatura asig = new Asignatura(cod, nota);

            if (!listAsignaturas.add(asig)){
                System.err.println("esta asignatura ya existe, intente de nuevo...");
                continue;
            }
            i++;
        }
        double notaMedia = notaMedia(expediente, name , ape,listAsignaturas);

        System.out.println("La nota media es: " + notaMedia);

        //  Esta iteracion es solo para ver los datos de las asignaturas
        listAsignaturas.forEach(System.out::println);

    }
    //  no entiendo muy bien para que le pasas mas datos al metodo si luego el ejercicio no te pide que hagas nada con ellos.
    private static double notaMedia(int expediente, String nombre, String apellidos, Collection<Asignatura> asignaturas){
        return asignaturas.stream().mapToDouble(Asignatura::getNota).sum()/asignaturas.size();
    }
}
