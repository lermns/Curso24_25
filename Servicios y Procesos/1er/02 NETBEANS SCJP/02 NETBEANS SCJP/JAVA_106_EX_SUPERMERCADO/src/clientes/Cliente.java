// Crear la clase Cliente que realizará la compra de los artículos. El cliente
// dispone de un nombre y una cesta (array de Articulo) además de la sobrecarga
// del método comprar. Así, se puede invocar a comprar pasando un conjunto de
// artículos separados por comas (parámetros variables) o bien, sin indicar nada,
// en cuyo caso se elegirá automáticamente tanto el tamaño de la cesta (mínimo 1
// y máximo 5) así como lo que se añadirá a la misma. Se añade un método para
// obtener la cesta del cliente.


package clientes;

import supermercado.*;

public class Cliente {

    private Articulo[] cesta;
    private String nombre;
    
    public Cliente(String nombre) {
        this.nombre = nombre;
    }    
    
    // COMPRAR 1 A 1 ... PARÁMETROS VARIABLES
    public void comprar(Articulo ... cesta) {
        this.cesta = cesta;
    }

    // COMPRAR ALEATORIAMENTE ... 1 A 5.
    public void comprar() {
        
        // CREAMOS AQUÍ EL ARRAY CON LOS ARTICULOS, PERO REALMENTE DEBERÍAN
        // ESTAR FUERA DECLARADOS FUERA CLASE (CENTRALIZACIÓN).
        final Articulo[] articulosDisponibles = 
            {
                // tenemos un total de 5 artículos
                new Cebolla(),  // posición 0.
                new Lechuga(),  // posición 1.        
                new Pan(),      // posición 2.
                new Pimiento(), // posición 3.        
                new Tomate()    // posición 4.
            };
        
        // ELEGIR EL TAMAÑO DE LA CESTA ALEATORIAMENTE: mínimo 1, máximo 5
        int cuantos = (int)(Math.random()*articulosDisponibles.length + 1); // [1 .. 5].
        System.out.println("\nTAMAÑO DE LA CESTA ... " + cuantos + "\n");
        
        cesta = new Articulo[cuantos];
        
        // ELEGIR LOS ARTÍCULOS ALEATORIAMENTE HASTA COMPLETAR LA CESTA.
        for (int i = 0; i < cesta.length; i++) {
            int cual = (int)(Math.random()*articulosDisponibles.length);
            cesta[i] = articulosDisponibles[cual];
        }
    }

    public Articulo[] obtenerCesta() {
        return cesta;
    }   
}