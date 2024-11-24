// Realizar una prueba de movimientos para la clase Grua, generando un objeto de ésta
// e invocando a su método mover (parametrizado), para alcanzar distintas posiciones.


package pruebas;

import clases.Grua;


public class PruebaMovimientos {

    public static void main(String[] args) {

        // Al crearse el objeto Grua se inicia su posición X-Y en 0,0.
        Grua grua = new Grua();
    
        grua.mover(20, 20);
            
        grua.mover(10, 10);
        
        grua.mover(-10, -10);
        
        grua.mover(-20, -20); 
        
        grua.mover(0, 0); 
    }
}