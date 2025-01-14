package AyudaEmms.TresEnRaya;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String [][]t=new String[3][3];
        crearTablero(t);
        String jugador="X";
        String PC = "O";
        int x;
        int y;
        Scanner sc=new Scanner(System.in);

        int contadorTemp = 0;
        mostrarTablero(t);

        do {

            System.out.println("Jugador 1 (X) mueve ficha");
            System.out.println("Selecciona fila");
            x = sc.nextInt();
            System.out.println("Selecciona columna");
            y = sc.nextInt();

            int puesto = colocaFicha(jugador, x-1, y-1, t);
            if(puesto == -1){
                continue;
            }

            mostrarTablero(t);
            if (comprobarGanador(jugador, t)) System.exit(0);

            do {
                System.out.println("Ordenador mueve ficha");

                int randPCx = (int) (Math.random() * 3);
                int randPCy = (int) (Math.random() * 3);

                puesto = colocaFicha(PC, randPCx, randPCy, t);
            }while (puesto==-1 && contadorTemp<4);

            mostrarTablero(t);

            if (comprobarGanador(jugador, t)) System.exit(0);

            contadorTemp++;

        }while(contadorTemp < 5);
        System.out.println("Empate...!");
        sc.close();
    }

    private static boolean comprobarGanador(String jugador, String[][] t) {
        String valor="";
        String valorDiagonalA="";
        String valorDiagonalB="";

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                valor+=t[i][j];
                if (i==j){
                    valorDiagonalA+=t[i][j];
                }
                if (i==0){
                    valorDiagonalB = t[i][t.length-1]+t[i+1][i+1]+t[t.length-1][i];
                }
            }
            if (valor.equals("XXX") || valor.equals("OOO")){
                System.out.println("El jugador " + (jugador.equals("O")?"PC":"Persona") + " ha ganado...!!");
                return true;
            }
            valor="";
        }

        if (valorDiagonalA.equals("XXX") || valorDiagonalA.equals("OOO")){
            System.out.println("El jugador " + (jugador.equals("O")?"PC":"Persona") + " ha ganado...!!");
            return true;
        }

        if (valorDiagonalB.equals("XXX") || valorDiagonalB.equals("OOO")){
            System.out.println("El jugador " + (jugador.equals("O")?"PC":"Persona") + " ha ganado...!!");
            return true;
        }
        return false;
    }

    private static int colocaFicha(String jugador, int x, int y, String[][] t) {

        if(t[x][y].isBlank())
        {
            t[x][y] = jugador;
            return 0;
        }
        System.out.println("OCUPADA\nVuelva a intentarlo " + jugador);
        return -1;
    }

    public static void crearTablero(String [][]t)
    {
        for(int i = 0; i < t.length; i++)
        {
            for(int j = 0; j < t.length; j++)
            {
                t[i][j] = " ";
            }
        }
    }

    public static void mostrarTablero(String [][]t)
    {
        System.out.println("**********");

        for (int i = 0; i < t.length; i++)
        {
            System.out.print("|");

            for (int j = 0; j < t[i].length; j++)
            {
                System.out.print(t[i][j]);
                System.out.print(" |");
            }

            System.out.println();

            System.out.println("**********");
        }
    }
}
