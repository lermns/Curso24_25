// Crear un clase que simule la compra de bebidas por parte de un cliente. Dicha clase
// permitirá la elección explícita de las bebidas a través de un método con línea de
// parámetros variables. De igual forma, se dispondrá de un método que seleccione de
// forma aleatoria el total a comprar, con un mínimo de 3 y un máximo de 8. En todos
// los casos, se mostrará por pantalla la compra realizada, indicándose nombre, precio
// y capacidad tanto individual cómo globalmente.


package tienda;

import bebidas.*; // importación fácil, pero es mejor ver que clases exactamente se están utilizando.
import interfacesbebida.InterfazBebidas;

public class Cliente {
    
    private String nombre;
    
    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    
    // BEBIDAS ELEGIDAS POR EL CLIENTE 1 A 1.
    public void comprarBebidas(Bebida ... bebidas) { // b1,b2,b3 ... o un Bebida[].       
        int importeTotal = 0;
        int volumenTotal = 0;
        
        System.out.println(nombre.toUpperCase() + 
                " HA COMPRADO: \n");
        
        for(Bebida bebida : bebidas) {
            System.out.println("---> " + bebida);
            importeTotal += bebida.obtenerPrecio();
            volumenTotal += bebida.obtenerVolumen();
        }
        
        System.out.println("\n");
        System.out.println("NUMERO TOTAL DE BOTELLAS = " + bebidas.length);
        System.out.println("VOLUMEN TOTAL = " + volumenTotal + " Cl");
        System.out.println("\n___________________________________________");
        System.out.println("IMPORTE TOTAL = " + importeTotal + " €");
        System.out.println("___________________________________________\n");
    }
    

    // BEBIDAS ALEATORIAS:
    public Bebida[] comprarBebidas() {
        
        int cuantas = (int)(Math.random()*6) + 3; // [3 .. 8] MÍNIMO 3, MÁXIMO 8.
        
        Bebida[] cesta = new Bebida[cuantas];
        
        for (int i = 0; i < cesta.length; i++) {
            // TENEMOS UN TOTAL DE 5 TIPOS DE BEBIDAS. SI AÑADIMOS MÁS, EL CÓDIGO SE
            // AJUSTA AUTOMÁTICAMENTE ... INTENTAR SIEMPRE HACERLO LO MÁS FLEXIBLE
            // POSIBLE, ALEJÁNDONOS DEL USO DEL "HARD-CODING" (ESTABLECER LOS VALORES
            // CONSTANTES A USAR DE UNA FORMA DIRECTA, EN EL PROPIO CÓDIGO).
            int posicion = (int)(Math.random()*InterfazBebidas.bebidas.length); // [0 .. 4]
            cesta[i] = InterfazBebidas.bebidas[posicion];
        }
        
        return cesta;
    }
    
    
    public static void main(String[] args) {
        
        Bebida b1 = new CocaCola();
        Bebida b2 = new JB();
        Bebida b3 = new Brugal();
        Bebida b4 = new Larios();
        Bebida b5 = new Absolut(); 
        
        // COMPRAR LAS BEBIDAS A VOLUNTAD, 1 A 1.
        Cliente juan = new Cliente("JUAN");        
        juan.comprarBebidas(b1,b2,b3,b4,b5);  // pasamos las bebidas 1 a 1 separadas por comas.
        System.out.println("\n............................................\n");
        
        // OBSERVAR:
        // La invocación más interna invoca a comprarBebidas(), lo que nos devuelve
        // un Bebida[]. Con este array, invocamos al que pide parámetros varibles o
        // lo que es lo mismo, una array de Bebidas:        
        //juan.comprarBebidas(juan.comprarBebidas());
        
        Bebida[] cesta = juan.comprarBebidas();
        juan.comprarBebidas(cesta); // pasamos todo el array de bebidas.              
    }
}