// Crear una clase Grua que establezca 2 atributos para designar las coordenadas de
// un plano X-Y. Dicha clase implementará la interfaz de movimientos, debiendo dar
// así implementación a todos y cada uno de sus métodos. En función del movimiento
// básico que se realice, se sumará o restará 1 a la coordenada correspondiente además
// de imprimirse un caracter de flecha. La lógica de negocio del método que solicita 2
// parámetros de entrada se basará en la invocación repetitiva del resto de métodos para
// movimientos básicos.

// Nota: Es un buen uso el no aglutinar toda la funcionalidad en un mismo método
// (gran cantidad de código). Al igual que con las clases (High Cohesión), debemos 
// seguir la técnica de "dividir para vencer" que generará un código más comprensible,
// extensible, mantenible y reutilizable.

package clases;

import interfaces.InterfazMovimientos;


public class Grua implements InterfazMovimientos {

    private int posX; // inicialmente estamos en (0,0).
    private int posY;
    
    @Override // implementación del método correspondiente de la interfaz.
    public void moverDerecha() {
        System.out.print(" → "); // No hacemos println, sino simplemente print.
        posX++;
    }

    @Override
    public void moverIzquierda() {
        System.out.print(" ← ");
        posX--;
    }

    @Override
    public void moverArriba() {
        System.out.print(" ↑ ");
        posY++;
    }

    @Override
    public void moverAbajo() {
        System.out.print(" ↓ ");
        posY--;
    }

    
    @Override
    public void mover(int posFinalX, int posFinalY) { // llamar a los básicos.        
        
        // COMPROBAR Y MOVER ... podemos usar un bucle while, do-While o cómo en este caso, un for.        
        
        // MOVIMIENTO EN EL EJE X:
        
        // MOVIMIENTO A DERECHAS (POSICIÓN FINAL > POSICIÓN INICIAL)
        for (/*NADA*/; posX < posFinalX;/*NADA*/) { // automáticamente se ve si es a la derehca o a la izquierda.
            moverDerecha();
        }

        // MOVIMIENTO A IZQUIERDAS (POSICIÓN FINAL < POSICIÓN INICIAL)        
        for (/*NADA*/; posX > posFinalX;/*NADA*/) {
            moverIzquierda();
        }

        
        // MOVIMIENTO EN EL EJE Y:        
        for (/*NADA*/; posY < posFinalY;/*NADA*/) {
            moverArriba();
        }
        
        for (/*NADA*/; posY > posFinalY;/*NADA*/) {
            moverAbajo();
        }
        
        System.out.println("\n______________________________________________________\n");
        System.out.println("PALANCA EN POSICION FINAL: X =" + posX + " , Y = " + posY);
        System.out.println("\n______________________________________________________\n");
    }
}