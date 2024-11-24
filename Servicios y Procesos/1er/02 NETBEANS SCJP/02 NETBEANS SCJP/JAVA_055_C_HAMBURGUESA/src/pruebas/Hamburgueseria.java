// Crear una clase que genere distintos tipos de Hamburguesa en base a la sobrecarga
// de constructores de que se dispone. Utilizar además el método para la generación
// aleatoria de la Hamburguesa, imprimiéndose en todos los casos el ticket.


package pruebas;

import clases.*;

public class Hamburgueseria {

    public static void main(String[] args) {
        
        Ingrediente extra1 = new Tomate();
        Ingrediente extra2 = new Cebolla();
        Ingrediente extra3 = new Pepinillo();
        
        Hamburguesa h1 = new Hamburguesa();     
        h1.imprimirTicket();
        
        System.out.println("\n\n\n");
        
        Hamburguesa h2 = new Hamburguesa(extra1);     
        h2.imprimirTicket();
               
        System.out.println("\n\n\n");
        
        Hamburguesa h3 = new Hamburguesa(extra1,extra2);     
        h3.imprimirTicket();
                
        System.out.println("\n\n\n");

        Hamburguesa h4 = new Hamburguesa(extra1,extra2,extra3);     
        h4.imprimirTicket();
        
        System.out.println("\n\n\n");

        Hamburguesa h0 = Hamburguesa.generarHamburguesaAleatoria();
        h0.imprimirTicket();
        
        System.out.println("\n");        
    }   
}