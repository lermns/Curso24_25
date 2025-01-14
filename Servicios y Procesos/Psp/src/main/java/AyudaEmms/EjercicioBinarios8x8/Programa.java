package AyudaEmms.EjercicioBinarios8x8;

import java.util.Random;
import java.util.Scanner;

public class Programa {
    private static final int SIZE = 8;
    private static int [][] matriz = new int[SIZE][SIZE];
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int option = 0;
        do {
            menu();
            System.out.print("Elige opción: ");
            option = src.nextInt();
            switch(option) {
                case 1 -> init();
                case 2 -> display();
                case 3 -> invest();
                case 4 -> System.out.println("Número de ceros que hay: " + count(0));
                case 5 -> System.out.println("Número de unos que hay: " + count(1));
                case 6 -> base10Row();
                case 7 -> base10Column();
                case 8 -> System.out.println("Saliendo...");
                default -> System.err.println("Opción no existente");
            }
        }while(option != 8);
        src.close();
    }

    public static void menu() {
        System.out.print("1 - Iniciar matriz\n"
                + "2 - Mostra matriz\n"
                + "3 - Invertir toda la matriz\n"
                + "4 - Indicar cuantos ceros hay en la matriz\n"
                + "5 - Indicar cuantos unos hay en la matriz\n"
                + "6 - Calcular por filas en base 10\n"
                + "7 - Cacular por columnas en base 10\n"
                + "8 - Salir del programa\n");
    }

    public static void init() {
        Random random = new Random();
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                matriz[i][j] = random.nextInt(2);
            }
        }
        System.out.println("Matriz inicializada");
    }

    public static void display() {
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void invest() {
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                matriz[i][j] = matriz[i][j] == 0 ? 1 : 0;
            }
        }
        System.out.println("Se ha invertido con exito");
    }

    public static int count(int num) {
        int count = 0;
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                if(matriz[i][j] == num)
                    count++;
            }
        }
        return count;
    }

    public static void base10Row() {
        String[] values = new String[SIZE];
        for(int i=0;i<SIZE; i++) {
            int base10 = 0;
            String binaryToStr = "";
            for(int j = 0; j < SIZE; j++) {
                binaryToStr += (char) ('0' + matriz[i][j]);
                base10 += matriz[i][j] * Math.pow(2, SIZE - j - 1);
            }
            values[i] = "Fila " + (i + 1) + ": [Binario - " + binaryToStr + "] a [Decimal - " + base10 + "]" ;
            binaryToStr = "";
        }
        printBase10(values);
    }

    public static void base10Column() {
        String[] values = new String[SIZE];
        for (int j = 0; j < SIZE; j++) {
            int base10 = 0;
            String binaryToStr = "";
            for (int i = 0; i < SIZE; i++) {
                binaryToStr += (char) ('0' + matriz[i][j]);
                base10 += matriz[i][j] * Math.pow(2, SIZE - i - 1);
            }
            values[j] = "Columna " + (j + 1) + ": [Binario - " + binaryToStr + "] a [Decimal - " + base10 + "]";
        }
        printBase10(values);
    }

    public static void printBase10(String[] values) {
        for(int i=0;i<values.length;i++)
            System.out.println(values[i]);
    }
}
