package Threads;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Simula el juego de piedra, papel o tijera utilizando la línea de comandos de java.
        (Para los que no conozcan el juego, los dos adversarios eligen entre piedra, papel o tijera y
        muestran su elección al mismo tiempo. La tijera gana al papel, el papel gana a la piedra y la
        piedra gana a la tijera. Si ambos eligen lo mismo la partida acaba en empate).
        Para ello, muestra por pantalla un menú con varias opciones:
        1) Sacar piedra
        2) Sacar papel
        3) Sacar tijera
        4) Salir
        Mientras que el usuario no elija la opción 4 el programa seguirá funcionando.
        Una vez se selecciona una opción (piedra, papel o tijera), simula una selección aleatoria por
        parte de la máquina y comprueba el resultado de la partida.
*/

        int opcion, opcionMaquina;
        do {
            System.out.println("1) Sacar piedra\n2) Sacar papel\n3) Sacar tijera\n4) Salir");
            opcion = new Scanner(System.in).nextByte();

            if(opcion>0 && opcion<4){
                opcionMaquina = (int)(Math.random()*3)+1;
                retPrint("usuario", opcion);
                retPrint("ordenador", opcionMaquina);
            }else if(opcion==4) break;


        }while (true);


        //prueba();
    }

    private static void retPrint(String name, int opc){
        if (opc==1){
            System.out.println(name + " saca piedra");
        } else if (opc==2) {
            System.out.println(name + " saca papel");
        }else
            System.out.println(name + " saca tijera");
    }

    /*private static boolean retGanador(int opcUser, int opcComp){
        if (opcUser<opcComp){

        }
    }*/

    private static void prueba(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] opciones = {"piedra", "papel", "tijeras", "salir"};

        String[][] matrizResultados = {
                // piedra, papel, tijeras
                {"Empate", "Perdiste", "Ganaste"},  // jugador elige piedra
                {"Ganaste", "Empate", "Perdiste"},  // jugador elige papel
                {"Perdiste", "Ganaste", "Empate"}   // jugador elige tijeras
        };

        while (true) {
            int computadoraIndex = random.nextInt(3);

            System.out.println("Elige:\n 1) Piedra \n 2) Papel \n 3) Tijeras \n 4) Salir \n");
            Integer jugadorIndex = scanner.nextInt()-1;

            if (jugadorIndex <= 2 && jugadorIndex >= 0) {
                String resultado = matrizResultados[jugadorIndex][computadoraIndex];
                System.out.println("El ordenador eligió: " + opciones[computadoraIndex] +
                        " y tu elegiste: " + opciones[jugadorIndex] + "\n");

                System.out.println("Resultado: " + resultado + "\n");
            }
            else if (jugadorIndex == 3) break;
            else System.out.println("Opción no válida. Debes elegir entre piedra, papel o tijeras.");
        }

        scanner.close();
    }
}
