// Crear una clase que genere objetos de cada una de las clases de implementación
// Menor y Adulto, controlándose éstos a través de sus respectivas interfaces
// (programa en base a supertipos y no en base a implementaciones - regla POO).
// Generar previamente el objeto/s Tienda para poder instanciar los anteriores Menor
// y Adulto. Realizar distintas compras obteniéndo el balance de ventas parcial y total
// de las tiendas.


package pruebas;

import clases.Adulto;
import clases.Menor;
import clases.Tienda;
import interfaces.InterfazAdulto;
import interfaces.InterfazMenor;

public class ComprasMenorAdulto {

    public static void main(String[] args) {
        
        Tienda sol = new Tienda("SOL"); // la tienda de Sol.
        
        InterfazMenor menor1 = new Menor(sol);
        InterfazMenor menor2 = new Menor(sol);
        InterfazAdulto adulto1 = new Adulto(sol);
        InterfazAdulto adulto2 = new Adulto(sol);

        menor1.comprarGolosinas(1);
        
        menor2.comprarGolosinas(2);
        
        adulto1.comprarAlcohol(3);
        adulto1.comprarGolosinas(4);
        
        adulto2.comprarTabaco(5);
        adulto2.comprarGolosinas(6);
                
        System.out.println(sol); // balance parcial de ventas correspondiente a ésta tienda.
        
        System.out.println("\n.................................................\n");
        
        //////////////////////////////////////////////////        
        
        Tienda atocha = new Tienda("ATOCHA"); // la tienda de Atocha.
        
        InterfazMenor menor3 = new Menor(atocha);
        
        InterfazAdulto adulto3 = new Adulto(atocha);
        
        menor3.comprarGolosinas(10);

        adulto3.comprarGolosinas(11);
        adulto3.comprarAlcohol(12);
        adulto3.comprarTabaco(13);
                
        System.out.println(atocha); // balance parcial de ventas correspondiente a ésta tienda.
        
        /////////////// BALANCE TOTAL CORRESPONDIENTE A TODAS LAS TIENDAS //////////////
        
        Tienda.balanceVentas(sol,atocha); // método con parámetros variables.
    }
}