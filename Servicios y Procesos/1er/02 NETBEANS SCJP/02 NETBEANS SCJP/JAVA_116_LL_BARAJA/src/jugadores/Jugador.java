// Crear la clase Jugador, que dispondrá de un nombre y un conjunto de Cartas
// almacenadas en una colección de tipo LinkedList. Se definen los métodos para
// obtener el nombre del jugador, y visualizar las cartas, así como para determinar
// el valor númerico total de las mismas.


package jugadores;

import cartas.Carta;
import java.util.LinkedList;

public class Jugador {

    private String nombre;
    LinkedList<Carta> lasCartas;

    
    public Jugador(String nombre, LinkedList<Carta> lasCartas) {
        this.nombre = nombre;
        this.lasCartas = lasCartas; // recibie un conjunto de cartas de la baraja.
    }

    
    public String getNombre() {
        return nombre;
    }
    
    
    public void visualizarCartas() {
        System.out.println("LAS CARTAS DE ... " + nombre);
        for (Carta carta : lasCartas) {
            System.out.println(carta);
        }
    }
    
    
    public int sumarCartas() {
        
        // sumar los números de las cartas de forma que el que tenga el valor
        // más alto, gana la partida (el palo no es relevante).
        
        int sumaTotal = 0;
        
        for (Carta carta : lasCartas) {
            sumaTotal += carta.getNumero();
        }
        
        return sumaTotal;
    }
    
}