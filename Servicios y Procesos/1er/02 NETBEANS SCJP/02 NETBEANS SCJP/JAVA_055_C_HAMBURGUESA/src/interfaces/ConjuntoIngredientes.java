// Declaramos en una interfaz un array con todos los posibles ingredientes que podremos
// usar en la hamburguesa (cada uno de ellos ocupa una posición).


package interfaces;

import clases.*; // permite al sistema importar aquellas clases necesarias.

public interface ConjuntoIngredientes {

    //public static final

    // Creamos un array de ingredientes y lo rellenamos con un objeto de cada tipo.
    // Lo utilizaremos más tarde para generar la Hamburguesa aleatoria (elegir una
    // posición del array al azar y obtener una referencia al objeto que contiene).
    
    Ingrediente[] todos = { // 5 posibles extras para la hamburguesa aleatoria.        
                            new Carne(), // posición 0.
                            new Queso(),
                            new Tomate(),
                            new Cebolla(),
                            new Pepinillo() // posición 4.
                         };    
}