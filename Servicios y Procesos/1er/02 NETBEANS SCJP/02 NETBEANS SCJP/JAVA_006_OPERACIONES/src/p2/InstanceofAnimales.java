// Crear las clases Animal, Gato y Perro dotándolas del método emitirSonido() que se declarará
// en la clase madre Animal (abstracta) y que será sobrescrito por las clases hijas (@Override).

// Cargar una referencia de tipo Animal con un objeto de cada una de dichas clases y comprobar
// cómo utilizando el operador instanceof, podemos comprobar el tipo del objeto apuntado por
// la referencia y en consecuencia realizar el DOWNCASTING correcto, sin problemas ClassCastException.

// El operador instanceof nos va a permitir comprobar la naturaleza del objeto cargado en la referencia,
// es decir, si cumple o no una determinada regla IS-A con respecto a una determinada clase o interfaz.


package p2;

import java.util.Random;
// NUEVAMENTE VOLVEMOS A CREAR TODAS LAS CLASES EN EL MISMO FICHERO POR SENCILLEZ.

abstract class Animal {
    public abstract void emitirSonido(); // Supertipo, que cada subclase defina el método a su manera.
}


class Gato extends Animal {

    @Override //se encarga de comprobar que el método que se tiene que sobreescribir se sobrecarga
    public void emitirSonido() {
        System.out.println("MIAUUU");
    }
}


class Perro extends Animal {
  
    @Override
    public void emitirSonido() {
        System.out.println("GUAAUUU");
    }
}
public class InstanceofAnimales {

    // COMPROBAR EL TIPO REAL DE OBJETO APUNTADO POR LA REFERENCIA ... instanceof. 
    // SE SIGUE LA MISMA REGLA DEL CASTING PARA VER SI EL COMPILADOR NOS DEJA O NO
    // APLICAR EL OPERADOR instanceof.
    
    public static void main(String[] args) {
        
        //Animal animal = new Animal(); // error, es clase abstracta luego no podemos
                                        // pero si rellenar con algo que cumpla IS-A.
                                        //Es un un supertipo
        
        //System.out.println("animal es instancia de Animal ..." +
        //      (animal instanceof Animal));
        
        System.out.println("\n___________________________________________\n");
        
        Animal a = new Gato(); //referencia d e tipo animal apuntando a un objeto de clase "Gato"

        System.out.println("animal es instancia de Animal ..." +
                (a instanceof Animal)); // true.        

        System.out.println("animal es instancia de Gato ..." +
                (a instanceof Gato)); // true.        
        
        System.out.println("\n___________________________________________\n");
        
        a = new Perro();

        System.out.println("animal es instancia de Animal ..." +
                (a instanceof Animal)); // true.        

        System.out.println("animal es instancia de Perro ..." +
                (a instanceof Perro)); // true. 
        
        System.out.println("\n___________________________________________\n");
        
        //Animal unAnimal = new Gato();
        Animal unAnimal = new Perro(); // comentar el anterior y usar este para probar.
              
        
        Animal[] animales= {new Gato(), new Perro()};
        int aleatorio = (int) (Math.random()*2);// [0..1]
        unAnimal = animales[aleatorio];
        
        unAnimal.emitirSonido();// con esta manera se evitaría el if-else que viene a continuación
        System.out.println("Tienes un "+unAnimal.getClass().getSimpleName());//con esta manera se evitaría el if-else que viene a continuación
        
        if(unAnimal instanceof Gato) {
            // Ok, se fuerza casting y se permite porque hay relación entre las clases.
            Gato unGato = (Gato)unAnimal;
            System.out.println("TIENES UN ... " + unGato.getClass().getSimpleName());
            unGato.emitirSonido();
        } else {
            Perro unPerro = (Perro)unAnimal;
            System.out.println("TIENES UN ... " + unPerro.getClass().getSimpleName());
            unPerro.emitirSonido();
        }
        
        // error, no hay relación entre las clases.
        //String cadena = (String)unAnimal; // NO PUEDE APLICARSE (casting) NI instanceof.
    }
}

