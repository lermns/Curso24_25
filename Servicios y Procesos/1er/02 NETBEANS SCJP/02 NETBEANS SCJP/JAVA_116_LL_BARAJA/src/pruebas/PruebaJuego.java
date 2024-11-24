package pruebas;

import barajas.Baraja;
import jugadores.Jugador;


public class PruebaJuego {

    // PRUEBA DEL JUEGO:

    private static final int cuantas = 10;
    
    
    public static void main(String[] args) {
        
        Baraja baraja = new Baraja();
        baraja.visualizarCartas(baraja.obtenerLasCartas());
        
        System.out.println("\n___________________________________________\n");
        
        baraja.barajear();
        baraja.visualizarCartas(baraja.obtenerLasCartas());
        
        System.out.println("\n___________________________________________\n");
        
                
        Jugador ana = new Jugador("ANA",baraja.repartirCartas(cuantas));
        Jugador juan = new Jugador("JUAN",baraja.repartirCartas(cuantas));  
        
        ana.visualizarCartas();
        
        System.out.println("\n___________________________________________\n");
        
        juan.visualizarCartas();
        
        System.out.println("\n___________________________________________\n");
        
        baraja.quienGana(ana, juan);
        
        System.out.println("\nFIN DE IMPRESION\n");   
    }   
    
}