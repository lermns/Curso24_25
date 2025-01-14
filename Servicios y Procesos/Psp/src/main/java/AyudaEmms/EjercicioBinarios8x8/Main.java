package AyudaEmms.EjercicioBinarios8x8;
/**
 *@author Leonardo Ramos B.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] arryBinario=null;
        boolean bandera;
        do{
            bandera=true;
            System.out.println("""
                    Seleccione:
                       1.   Inicializar la matriz de manera aleatoria.
                       2.	Mostrar la matriz por pantalla (“bonita”)
                       3.	Invertir toda la matriz (0’s por 1’s)
                       4.	Indicar cuántos ceros hay en la matriz
                       5.	Indicar cuantos unos hay en la matriz
                       6.	Calcular por filas en base 10
                       7.	Calcular por columnas en base 10
                       8.	Salir del programa.
                    """);
            int opc = new Scanner(System.in).nextInt();

            switch (opc){
                case 1 -> {
                    arryBinario = new int[4][4];
                    iniciarArry(arryBinario);
                    System.out.println("Array inicializado");
                }
                case 2 -> {
                    if(arryBinario==null){
                        System.out.println("Array vacío");
                    }else
                        mostrarArry(arryBinario);
                }
                case 3 -> {
                    if(arryBinario==null){
                        System.out.println("Array vacío");
                    }else {
                        invertirArry(arryBinario);
                        System.out.println("array invertido");
                    }
                }
                case 4 -> {
                    if(arryBinario==null){
                        System.out.println("Array vacío");
                    }else
                        System.out.println("Cantidad de ceros: " + cantidadCeroUno(arryBinario)[0]);
                }
                case 5 -> {
                    if(arryBinario==null){
                        System.out.println("Array vacío");
                    }else
                        System.out.println("Cantidad de unos: " + cantidadCeroUno(arryBinario)[1]);
                }
                case 6 -> {
                    if(arryBinario==null){
                        System.out.println("Array vacío");
                    }else {
                        System.out.println("Calculo en base de 10, columnas");
                        calcularBaseDiezFila(arryBinario);
                    }
                }
                case 7 -> {
                    if(arryBinario==null){
                        System.out.println("Array vacío");
                    }else {
                        System.out.println("Calculo en base de 10, columnas");
                        calcularBaseDiezColumna(arryBinario);
                    }
                }
                default -> bandera=false;
            }

        }while (bandera);
        System.out.println("fin del programa...!");
    }

    private static void iniciarArry(int[][] arryBinario){
        for (int i = 0; i < arryBinario.length; i++) {
            for (int j = 0; j < arryBinario[i].length ; j++) {
                arryBinario[i][j]= (int) (Math.random() * 2);
            }
        }
    }

    private static void mostrarArry(int[][] arryBinario){
        for (int[] i: arryBinario){
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void invertirArry(int[][] arryBinario){
        for (int i = 0; i < arryBinario.length; i++) {
            for (int j = 0; j < arryBinario[i].length ; j++) {
                arryBinario[i][j]= Math.abs(arryBinario[i][j]-1);
            }
        }
    }

    private static int[] cantidadCeroUno(int[][] arryBinario){
        int cantidadCero=0, cantidadTotal;
        for (int[] i: arryBinario){
            for (int j : i){
                if (j==0)
                    cantidadCero++;
            }
        }
        cantidadTotal=arryBinario[0].length*arryBinario.length;

        return new int[]{cantidadCero, cantidadTotal-cantidadCero};
    }

    private static void calcularBaseDiezFila(int[][] arryBinario){
        int fila, dblRes = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arryBinario.length; i++) {
            fila = arryBinario[i].length-1;
            for (int j = 0; j < arryBinario[i].length; j++) {
                sb.append(arryBinario[i][j]);
                sb.append(" ");
                dblRes += (int)(arryBinario[i][j]*(Math.pow(2.0, fila)));
                fila--;
            }
            System.out.println(sb + " --> " + dblRes);
            sb.setLength(0);
            dblRes=0;
        }
    }

    private static void calcularBaseDiezColumna(int[][] arryBinario){
        int columna, dblRes = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;

            for (int j = 0; j < arryBinario[i].length; j++) {
                columna = arryBinario[i].length-1;
                i=0;
                for (; i < arryBinario.length; i++) {
                    sb.append(arryBinario[i][j]);
                    sb.append(" ");
                    dblRes += (int)(arryBinario[i][j]*(Math.pow(2.0, columna)));
                    columna--;
                }
                System.out.println(sb + " --> " + dblRes);
                i=j;
                dblRes=0;
                sb.setLength(0);
            }
    }
}
