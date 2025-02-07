package Ejer_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][][] arryStrings = new String[4][4][4];

        String[][][] newArryString = instanciadorArrayStrings(arryStrings);

        for (String[][] strings : newArryString) {
            for (String[] string : strings) {
                for (String s : string) {
                    System.out.println(s);
                }
            }
        }

        System.out.println("\n------------------------------Que cadena quieres buscar: ------------------------------");
        String s = new Scanner(System.in).nextLine();
        int cantidad = extraerCadena(arryStrings, s);
        System.out.println("------------------------------ Cantidad: " + cantidad + " ------------------------------");
    }

    private static String[][][] instanciadorArrayStrings(String[][][] arryStrings){
        for (int i = 0; i < arryStrings.length; i++) {
            for (int j = 0; j < arryStrings[i].length; j++) {
                for (int k = 0; k < arryStrings[i][j].length; k++) {
                    arryStrings[i][j][k] = letrasRandom((int)((Math.random()*26)+5));
                }
            }
        }
        return arryStrings;
    }

    private static String letrasRandom(int num){
        StringBuilder strLetras = new StringBuilder();

        for (int i = 0; i < num; i++) {
            char caracter = (char)((int)(Math.random()*26)+65);
            strLetras.append(((int)(Math.random()*2)+1)==1?caracter:Character.toLowerCase(caracter));
        }
        return strLetras.toString();
    }

    private static int extraerCadena(String[][][] arryString, String cadena){
        int cont=0;
        for (String[][] strings : arryString) {
            for (String[] string : strings) {
                for (String s : string) {
                    if (s.equals(cadena)) cont++;
                }
            }
        }
        return cont;
    }
}
