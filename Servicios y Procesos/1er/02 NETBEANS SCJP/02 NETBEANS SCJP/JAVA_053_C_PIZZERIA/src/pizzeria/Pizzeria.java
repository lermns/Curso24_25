// Crear distintos objetos Pizza. Los 3 primeros sin indicar el tipo de masa, pero
// utilizando las clases de Pizza existentes (Margarita, Vegetal y Barbacoa). Para
// los 3 últimos elegiremos el tipo de masa "PAN". En todos los casos imprimir el
// ticket de la pizza para ver qué ingredientes contiene y cuál es su precio final.

// Este ejercicio busca poner de manifiesto el encadenamiento de constructores.
// Se podría crear una versión alternativa y más óptima, mediante el uso de los
// patrones de diseño Method-Factory o Abstract-Factory, pero como ya se ha 
// indicado, no es ese el fin perseguido.


package pizzeria;

import interfaces.InterfazNombres;
import pizzas.Pizza;
import pizzas.PizzaBarbacoa;
import pizzas.PizzaMargarita;
import pizzas.PizzaVegetal;

public class Pizzeria {

    public static void main(String[] args) {
        
        Pizza p1 = new PizzaMargarita();        
        System.out.println(p1);
        
        Pizza p2 = new PizzaVegetal();        
        System.out.println(p2);
        
        Pizza p3 = new PizzaBarbacoa();        
        System.out.println(p3);        
        
        
        System.out.println("\n\n......... ELEGIMOS LA MASA A UTILIZAR .........\n\n");
               
        Pizza p4 = new PizzaMargarita(InterfazNombres.PAN);        
        System.out.println(p4);
               
        Pizza p5 = new PizzaVegetal(InterfazNombres.PAN);        
        System.out.println(p5);
                       
        Pizza p6 = new PizzaBarbacoa(InterfazNombres.PAN);        
        System.out.println(p6);        
    }   
}