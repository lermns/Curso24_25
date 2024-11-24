// Crear una clase que instance un objeto Cliente para realizar la compra de
// distintos artículos, tanto por decisión propia cómo aleatoria. Imprimir en
// ambos casos el ticket correspondiente.


package supermercados;

import clientes.Cliente;


public class PruebaSupermercado {

    // HAREMOS USO DEL OBJETO SUPERMERCADO, QUE CONTIENE LA LÓGICA DE NEGOCIO
    // PARA COBRAR AL CLIENTE.
    
    public static void main(String[] args) {

        Cliente ana = new Cliente("ANA");

        /*
        // COMPRA 1 A 1
        Articulo a1 = new Pimiento();
        Articulo a2 = new Tomate();
        Articulo a3 = new Pan();
        Articulo a4 = new Lechuga();
        Articulo a5 = new Cebolla();

        // COMPRA PERSONALIZADA:
        ana.comprar(a1, a2, a3, a4, a5);        
        Supermercado.cobrar(ana);

        */
        // COMPRA ALEATORIA:
        System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::\n");
        
        ana.comprar();
        Supermercado.cobrar(ana);
        
    }
}