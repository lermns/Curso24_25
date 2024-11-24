// Crear una clase que compruebe el funcionamiento del polimorfismo a la hora
// de invocar al método pasarConsulta sobre el objeto pasado como parámetro.
// Para ello, crear un array de tipo Animal e introducir en él 1 objeto de cada
// tipo. Utilizar un bucle for-each para recorrerlo, realizando en cada iteración
// la citada consulta (invocación por lazy-binding).


package clinica;

import animales.*;

public class PruebaVeterinario {

    public static void main(String[] args) {
        
        Animal[] animales = {
                                new Gato(),
                                new Pajaro(),
                                new Iguana()        
                            }; 
        
        Veterinario veterinario = new Veterinario();
        
        for(Animal animal : animales) {
            veterinario.pasarConsulta(animal);
            System.out.println("\n\n");
        }
    }   
}