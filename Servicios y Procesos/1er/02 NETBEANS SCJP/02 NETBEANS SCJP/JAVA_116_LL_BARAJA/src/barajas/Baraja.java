// Crear la clase Baraja que se compondrá de un total de 52 Cartas, las cuáles
// se irán creando y almacenando en una colección LinkedList (opcionalmente marcada
// con género <Carta>). Inicialmente están ordenadas por palo y número y lo que se
// quiere es barajearlas. Para ello, se define un método que genere internamente
// otro LinkedList, sobre el que iremos depositando cada una de las cartas extraídas
// aleatoriamente de la colección original. Al terminar, se apuntará la referencia
// a la nueva colección. Con la baraja ya preparada, se procede a entregar un determinado
// número de cartas (elegido a voluntad) a cada uno de los 2 jugadores. Para ello, se
// utiliza el método pop (extracción comenzando por el principio) y una vez terminado
// se suman los valores numéricos de las cartas de cada jugador. El que obtenga el valor
// más alto es el que gana.

// Establecer los métodos que se consideren necesarios para implementar el presente juego.


package barajas;

import cartas.Carta;
import enumerados.Palos;
import java.util.LinkedList;
import jugadores.Jugador;


public class Baraja {    

    private LinkedList<Carta> lasCartas;

    
    public Baraja() {
    
        lasCartas = new LinkedList<Carta>();
        generarCartas();
    }
    
    
    private void generarCartas() {
        
        for (Palos palo : Palos.values()) {            
            for (int numero = 1; numero <= 13; numero++) {
                lasCartas.add(new Carta(palo,numero));
            }            
        }
    }
    
    
    public void visualizarCartas(LinkedList<Carta> listadoCartas) {
        for (Carta carta : listadoCartas) {
            System.out.println(carta);
        }
    }

    
    public void barajear() {
        // la colección que contendrá las cartas barajeadas.
        LinkedList<Carta> lasCartasBarajeadas = new LinkedList<Carta>();
        
        while(!lasCartas.isEmpty()) { // repetir mientras queden cartas
            int aleatorio = (int)(Math.random()*lasCartas.size());
            // añadir a las barajeadas lo que le quitamos a esta. El size disminuye en 1.
            lasCartasBarajeadas.add(lasCartas.remove(aleatorio));
        }
        
        lasCartas = lasCartasBarajeadas; // apuntar la referencia a barajeadas.
    }

    
    public LinkedList<Carta> repartirCartas(int cuantas) {
        
        if(lasCartas.size()< cuantas) {
            System.out.println("HAS PEDIDO REPATIR " + cuantas + " CARTAS Y "
                    + "SOLO HAY EN EL MAZO UN TOTAL DE " + lasCartas.size());
            
            System.out.println("\n --- FIN DE PROGRAMA ---- \n");
            System.exit(0);
        }
        
        LinkedList<Carta> mano = new LinkedList<Carta>();
        
        for (int i = 0; i < cuantas; i++) { // quitar empezando por el principio.
            mano.add(lasCartas.pop());
        }
        
        return mano;        
    } 
    
    
    public void quienGana(Jugador j1, Jugador j2) {
        
        int puntosJ1 = j1.sumarCartas(); // sumando las cartas, gana el máyor valor numérico.
        int puntosJ2 = j2.sumarCartas();        
    
        
        System.out.println("PUNTOS DE " + j1.getNombre() + " = " + puntosJ1);
        System.out.println("PUNTOS DE " + j2.getNombre() + " = " + puntosJ2);

        
        String ganador;
        
        if(puntosJ1 > puntosJ2) {
            ganador = "\nGANA EL JUGADOR ... " + j1.getNombre();
        } else {
            ganador = "\nGANA EL JUGADOR ... " + j2.getNombre();        
        }            
        
        System.out.println(ganador);
    }
    
    
    public LinkedList<Carta> obtenerLasCartas() {
        return lasCartas;
    }
    
}