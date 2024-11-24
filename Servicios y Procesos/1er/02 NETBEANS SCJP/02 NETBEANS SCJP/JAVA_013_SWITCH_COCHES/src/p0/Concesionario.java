// Crear una clase que pida una categoría (char) para el coche que se quiere comprar
// y que mediante un bloque switch nos indique los extras correspondientes a dicha 
// categoria. La categoría A es la de mayor rango y la C la de menor. Elementos:
// MINIBAR - LLANTAS DE ALEACION - MP3 STEREO.

// Opcionalmente, se puede crear otro bloque switch que nos indique el precio del coche. 


package p0;

public class Concesionario {

    public static void main(String[] args) {
        
        final char limousine = 'A';
        final char corvette = 'B';
        final char c3 = 'C';

        char[] categorias={'A','B','C'};
        int numAleatorio = (int) (Math.random()*categorias.length);
        
        
       
        char coche = categorias[numAleatorio];
        System.out.println("Tipo de coche: " + coche);
        switch (coche) {

          
            case limousine: 
                System.out.println("Es una Limousina. Vale 120000 €");
                break;
            case corvette:
                System.out.println("Es un Corvette. Vale 60000 €");
                break;
            case c3:
                System.out.println("Es un C3. Vale 9000 €");
                break;

            default:
                System.out.println("COCHE INCORRECTO");
        }
        System.out.println("Extras: -----------------------------------------");     
        switch (coche) {

         
            case limousine: 
                System.out.println("-  Minibar");
            case corvette:
                System.out.println("-  Llantas de aleación");
            case c3:
                System.out.println("-  MP3");
                break;
            default:
                System.out.println("COCHE INCORRECTO");
        }
        
    }
}