// Crear una clase Tienda que instancie los objetos Televisor y Ordenador, mostrando
// por pantalla el precio de cada uno de ellos, tanto sin IVA como con IVA. Hacer
// uso del supertipo constituído por la clase madre abstracta Articulo.

// Nota: Si sólo necesitamos de métodos podremos hacer uso del polimorfísmo y la 
// interfaz, pero si además necesitamos atributos, entonces se hace necesario el
// uso de la clase abstracta. La interfaz nos permite emular una herencia directa
// múltiple, mientras que con la clase abstracta, sólo podemos hacer uso de ella,
// de forma directa, una vez. Estudiar el caso y elegir lo que más convenga.


package pruebas;

import clases.Articulo;
import clases.Ipad;
import clases.Ordenador;
import clases.PlayStationV;
import clases.Televisor;

public class Tienda {

    public static void main(String[] args) {
    
        // Polimorfimo. El método llamado se resolverá por Lazy-Binding,
        // ya que es de instancia o polimórfico (manda el objeto sobre la
        // referencia).
        Articulo a1 = new Ordenador();
        Articulo a2 = new Televisor();
        Articulo a3 = new PlayStationV();
        Articulo a4 = new Ipad();
        
        a1.imprimirPrecioSinIVA();
        a1.imprimirPrecioConIVA();
        
        System.out.println("\n_________________\n");
        
        a2.imprimirPrecioSinIVA();
        a2.imprimirPrecioConIVA();        
        System.out.println("\n_________________\n");
        
        a3.imprimirPrecioSinIVA();
        a3.imprimirPrecioConIVA(); 
        
        
        System.out.println("\n_________________\n");
        
        a4.imprimirPrecioSinIVA();
        a4.imprimirPrecioConIVA(); 
    }    
}