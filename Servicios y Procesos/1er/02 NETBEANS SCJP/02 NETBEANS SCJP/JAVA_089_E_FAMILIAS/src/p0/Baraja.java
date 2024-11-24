// Crear la clase Baraja compuesta por elementos de tipo Carta, sabiendo que
// cada uno de ellos debe corresponder a una familia y a un parentesco. Definir
// un par de métodos para crear y visualizar las cartas.

// Total de cartas = número de familias * número de parentescos.


package p0;

public class Baraja {

    private Carta[] lasCartas; // contenedor de cartas (familias*parentescos)
    private final Familias[] lasFamilias;  // valores.
    private final Parentesco[] losParentescos; // valores. 
    
    public Baraja() {
        lasFamilias = Familias.values();
        losParentescos = Parentesco.values();
        
        int cuantas = lasFamilias.length * losParentescos.length;                
        lasCartas = new Carta[cuantas]; // constituir el elemento array.
        crearCartas();
        visualizarCartas();
    }
    
    private void crearCartas() {
        int contador = 0;
        
        // Utilizamos un bucle for anidado. Por cada familia, recorrer los parentescos.
        for (Familias familia : lasFamilias) {
            for(Parentesco parentesco : losParentescos) {
                lasCartas[contador++] = new Carta(familia,parentesco);            
            }
        }
    }
        
    public void visualizarCartas() {
        for (Carta carta : lasCartas) {
            System.out.println(carta);
        }
    }
}