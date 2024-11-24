// Crear una clase Acuario que defina una atributo de tipo List marcado con
// el género <Animal>. En él, se introducirán un total de 10 elementos de
// tipo Pez ó Tortuga (elegidos aleatoriamente). Comprobar cómo el compilador
// genera un error al tratar de introducir tipos no compatibles, es decir, 
// todo aquello que no sea tipo o subtipo de la clase Animal, género con el
// el que se marcó la referencia que maneja la colección. Finalmente, imprimir
// el contenido de la misma por pantalla.


package animales;

import java.util.ArrayList;
import java.util.List;


public class Acuario {

    public static void main(String[] args) {
        
        List<Animal> animales = new ArrayList<Animal>();

        // conjunto de animales que se venden en el acuario.
        Animal[] animalesDisponibles = {new Pez(), new Tortuga()};
        
        for (int i = 0; i < 10; i++) {
            int aleatorio = (int)(Math.random()*animalesDisponibles.length); // 0,1
            animales.add(animalesDisponibles[aleatorio]);
        }
        
        // error, los siguientes elementos no son compatibles:
        //animales.add(5);
        //animales.add("hola");        
        
        System.out.println(animales);   
    }   
    
}