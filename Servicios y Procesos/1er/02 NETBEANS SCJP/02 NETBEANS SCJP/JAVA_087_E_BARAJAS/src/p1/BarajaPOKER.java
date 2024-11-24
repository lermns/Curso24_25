// Crear la clase BarajaPoker, que se compone de 52 elementos de tipo CartaPoker.
// Declarar un atributo de tipo array CartaPoker y constituirlo en el constructor
// de la clase. Para ello, definir los métodos crearCartas (rellena el array) y
// visualizarCartas (muestra el contenido del array).


package p1;

import p0.PalosPOKER;

public final class BarajaPOKER {

    private CartaPOKER[] lasCartas; // es un array de objetos CartaPOKER.

    public BarajaPOKER() {
        lasCartas = new CartaPOKER[52]; // 13numeros * 4palos
        crearCartas();
        visualizarCartas();
    }
    
    private void crearCartas() {

        int contador = 0;

        // ELEGIR EL PALO: CORAZONES, DIAMANTES, TREBOLES, PICAS.
        for (PalosPOKER palo : PalosPOKER.values()) {

            // ELEGIR EL NÚMERO: [1..13]
            for (int numero = 1; numero <= 13; numero++) {
                lasCartas[contador++] = new CartaPOKER(palo, numero);
            }
        }
    }
    
    // Al final del doble bucle tendremos 4 palos * 13 números = 52 cartas.

    public void visualizarCartas() {
        
        // VISUALIZACIÓN CONTINUA:
        //        for (CartaPOKER carta : lasCartas) {
        //            System.out.println(carta);
        //        }
        
        // SALTO DE LÍNEA POR CADA CAMBIO DE PALO:
        for (int i = 0; i < lasCartas.length; ) { // 0 -> 51 en saltos de 13.
            
            System.out.println(lasCartas[i]); //0 .. 12 --> 1pos ... 13pos            
            
            if(++i%13 == 0) { // utilizar el contador para separar los palos.
                System.out.println("\n______________________\n");
            }
        }
    }
 
    
    public static void main(String[] args) {
        new BarajaPOKER();
    }
    
}