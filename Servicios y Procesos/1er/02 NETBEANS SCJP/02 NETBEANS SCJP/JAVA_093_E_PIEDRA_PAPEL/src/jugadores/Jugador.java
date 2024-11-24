// Crear la clase Jugador disponiendo ésta de los atributos necesarios para el
// nombre del jugador, el número de jugadas ganadas y la opción aleatoria jugada
// elegida (PPT) en cada momento, hasta que el juego finalice (3 ganadas). Se
// definen los métodos necesarios para consultar el estado de los atributos y
// la modificación de éstos (la clase Juego, a través de su método jugar hará uso
// de los mismos).

// Nota: Observar como la lógina de negocio del juego en sí, sus reglas, no está
// en la clase Jugador (no forma parte de él). En su lugar, será la clase Juego
// la que se encargue de implementarla (HIGH COHESION ... divide y vencerás).
// Se consigue un código más claro, reutilizable, fácil de mantener ... etc.

// Jugador ... la persona: nombre, jugadas ganadas, jugada elegida.
// Juego ..... las reglas: quién gana la jugada, incrementar jugadas ganadas,
//             cuántas jugadas hay que ganar para ser ganador final, mensajes.


package jugadores;

import enumerados.PPT;

public class Jugador {

    // atributos privados ... desacoplamiento (la clase juego no ve los atributos).
    private String nombre; 
    private int jugadasGanadas;
    private PPT jugada;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Métodos de negocio ... no se utiliza supertipo (I, CA) por hacerlo más sencillo.
    // No pueden ser estáticos ya que actúan sobre un determinado objeto y
    // sus propiedades (el estático pertenece a la clase, la nuve, y no sabe
    // nada de los posibles futuros objetos que se vayan a instanciar de ella).
    
    // Los métodos de negocio de Jugador serán utilizados por la clase Juego.
    
    // GETTERS:    
    public String consultarNombre() {
        return nombre;
    }
    
    public PPT consultarJugada() {
        return jugada;
    }

    public int consultarJugadasGanadas() {
        return jugadasGanadas;
    }
    
    // SETTERS:
    public void asignarJugada() {
        jugada = PPT.obtenerJugada(); // invocación al método estático.
    }
    
    public void incrementarJugadasGanadas() {
        jugadasGanadas++;
    }
}