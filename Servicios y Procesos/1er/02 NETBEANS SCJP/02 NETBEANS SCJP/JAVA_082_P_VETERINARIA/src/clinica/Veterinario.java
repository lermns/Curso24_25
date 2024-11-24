// Crear la clase Veterinario que disponga de un método que sirva para pasar
// consulta tanto a gatos como a iguanas, pajaros o cualquier otro animal.

// Comprobar cómo el programar en base a un supertipo y no a una implementación,
// reduce notoriamente el número de métodos a utilizar, haciendo a su vez el 
// código más comprensible, mantenible, menos propenso a fallos ... etc.


package clinica;

import animales.Animal;

public class Veterinario {

    // No necesitamos un método para cada tipo de objeto. La versión del método
    // se invocará por lazy-binding sobre el objeto al que en un determinado
    // momento este apuntando la referencia, ya que es método polimorfico.
    public void pasarConsulta(Animal animal) {
        
        String queAnimal = animal.getClass().getSimpleName().toUpperCase();
        
        System.out.println("SE LE PASA CONSULTA AL ANIMAL ... " + queAnimal);
        animal.chequear();

    }
}