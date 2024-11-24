// Crear la clase Juego que definirá la verdadera lógica de negocio de la aplicación.
// Se dispone de un atributo que determine el número de jugadas ganadas por un mismo
// jugador para que el juego termine, así como un contador para ver cuántas jugadas
// se han realizado en total para llegar a dicha finalización.
// Se define el método quienGana, recibiendo como argumentos de entrada 2 objetos de
// tipo Jugador, para implementar en él el código que determine la jugada ganadora
// (la forma más sencilla y limpia es utilizar distintos bloques switch para comparar
// la jugada de un jugador con la jugada de otro). Determinado el ganador se procede
// a realizar las incrementaciones adecuadas (contador de jugadas y jugadas ganadas).

// Nota: intentar separar la lógica de negocio lo mejor posible, sin caer en tratar de
// realizar un único método descomunal que pretenda hacerlo todo ni infinitos métodos
// que repitan una funcionalidad que podría agruparse en 1 mismo ... llegar a un equilibrio.


package juegos;

import jugadores.Jugador;


public class Juego {

    private static final int finJuego = 3; // gana el primero que llegue a 3.
    private static int contadorJugadas;

    // Método estático. Trabaja sobre la pareja de objetos que le pasen y luego,
    // al finalizar el método, se olvidará de ellos.
    // "ahora estas tú y mañana estará otro" ... usar y tirar.
    private static void quienGana(final Jugador j1, final Jugador j2) {
        
        switch(j1.consultarJugada()) { // SWITCH EXTERNO.
        
            case PIEDRA: // el jugador 1 dijo PIEDRA ... ver qué dijo el jugador 2:
                switch(j2.consultarJugada()) { // SWITCH INTERNO.
                    case PIEDRA: // si el jugador 2 dijo PIEDRA ... empate, volver a jugar.
                        System.out.println("EMPATADOS"); // mensaje. Empatados.
                        break; // salir del switch interno.
                    case PAPEL: // si el jugador 2 dijo PAPEL ... gana jugador 2.
                        System.out.println("GANA " + j2.consultarNombre()); // mensaje. Gana jugador 2.
                        j2.incrementarJugadasGanadas(); // incrementar jugadas ganadas de jugador 2.
                        break; // salir del switch interno.
                    case TIJERA: // si el jugador 2 dijo TIJERA ... gana jugador 1.
                        System.out.println("GANA " + j1.consultarNombre()); // mensaje. Gana jugador 1.
                        j1.incrementarJugadasGanadas(); // incrementar jugadas ganadas de jugador 1.
                        break; // salir del switch interno ... redundante pero válido para futuras modificaciones.
                }
                break; // salir del switch externo.
        

            case PAPEL: // si en lugar de PIEDRA, el jugador 1 dijo PAPEL ... se repite el proceso.
                switch(j2.consultarJugada()) {
                    case PIEDRA:
                        System.out.println("GANA " + j1.consultarNombre());
                        j1.incrementarJugadasGanadas();
                        break;
                    case PAPEL:
                        System.out.println("EMPATADOS");
                        break;
                    case TIJERA:
                        System.out.println("GANA " + j2.consultarNombre());
                        j2.incrementarJugadasGanadas();                        
                        break;
                }
                break;

                
            case TIJERA:
                switch(j2.consultarJugada()) {
                    case PIEDRA:
                        System.out.println("GANA " + j2.consultarNombre());
                        j2.incrementarJugadasGanadas();                        
                        break;
                    case PAPEL:
                        System.out.println("GANA " + j1.consultarNombre());
                        j1.incrementarJugadasGanadas();
                        break;
                    case TIJERA:
                        System.out.println("EMPATADOS");                        
                        break;
                }                
                break;        
        }    
    }

    // Método estático (usar y tirar).    
    public static void jugar(final Jugador j1, final Jugador j2) {
          
        while(j1.consultarJugadasGanadas()<finJuego && j2.consultarJugadasGanadas()<finJuego) {
        
            contadorJugadas++;
            
            j1.asignarJugada(); // {PIEDRA || PAPEL || TIJERA}
            j2.asignarJugada();
            
            System.out.println("\n_________________________________________________\n");
            System.out.println(j1.consultarNombre() + " HA ELEGIDO ... " + j1.consultarJugada());
            System.out.println(j2.consultarNombre() + " HA ELEGIDO ... " + j2.consultarJugada());
            System.out.println("\n");
            
            // Aquí se establece la lógica de negocio para ver quién ha ganado la actual
            // jugada y actuar en consecuencia (incrementar uno de los contadores y ver
            // si el juego debe terminar o hay que volver a jugar).
            quienGana(j1, j2);            
        }
        
        String ganador;
        
        if(j1.consultarJugadasGanadas() == finJuego) {
            ganador = j1.consultarNombre();
        } else {
            ganador = j2.consultarNombre();
        }
         
        System.out.println("\nFINALMENTE HA GANADO ... " + ganador + "\n\n");
        
        System.out.println(j1.consultarNombre() + " ... TOTAL JUGADAS GANADAS ..." + j1.consultarJugadasGanadas());
        System.out.println(j2.consultarNombre() + " ... TOTAL JUGADAS GANADAS ..." + j2.consultarJugadasGanadas());        
        System.out.println("TOTAL DE JUGADAS EFECTUADAS ... " + contadorJugadas);
    }
}