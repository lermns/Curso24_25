// Crear la clase PruebaJuego que enfrente a 2 jugadores.

// Nota: Observar cómo se ha diseñado la aplicación para que el comportamiento
// interno de las distintas clases PPT, Jugador y Juego sea independiente las
// unas de las otras (a pesar del hecho de no haber utilizado interfaces ni
// clases abstractas). Así, en todas ellas definimos atributos privados y una
// serie de métodos que podrán ser invocados para recibir algo o ejecutar una tarea.
// Así, conectando cada una de las partes INDIVIDUALES (loose - Coupled) obtenemos
// el TODO, la aplicación. Es en ésto en lo que se basa el paradigma de la POO,
// en objetos independientes colaborando entre sí (se comunican mediante el envío
// de mensajes, lo que equivale a la invocación a métodos).


package juegos;

import jugadores.Jugador;

public class PruebaJuego {

    public static void main(String[] args) {
        
        Jugador j1 = new Jugador("ANA"); // creación de los jugadores.
        Jugador j2 = new Jugador("JUAN");
           
        Juego.jugar(j1,j2); // punto de entrada al juego.
    }    
}
