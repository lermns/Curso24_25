// Crear una clase que defina una array de la clase Animal y a continuación rellenarlo
// con 1 instancia de la siguientes clases: Animal, Gato y Perro (un objeto de cada 
// una de ellas). Recuperar el Animal de la primera posición y castearlo (DOWNCASTING)
// al tipo Gato.

// Definir todas las clases en el presente fichero.

package p0;

public class ArrayAnimales {

    public static void main(String[] args) {
                      
        Animal[] misAnimales = new Animal[3];
        
        misAnimales[0] = new Animal();
        misAnimales[1] = new Gato();
        misAnimales[2] = new Perro();
        
        Animal animalPosicion0 = misAnimales[0];
        Animal animalPosicion1 = misAnimales[1];
        Animal animalPosicion2 = misAnimales[2];        
        
        System.out.println("posicion0 ---> " + animalPosicion0);
        System.out.println("posicion1 ---> " + animalPosicion1);
        System.out.println("posicion2 ---> " + animalPosicion2);
        
        System.out.println("\n____________________________________________\n");
        
        // CUIDADO AL FORZAR EL CASTING NO SEA QUE OBTENGAMOS ALGO QUE NO SEA GATO ... ClassCastException.
        // SE PUEDE UTILIZAR EL OPERADOR instanceof PARA ASEGURAR EL TIPO DE CASTING A UTILIZAR.
        
        //Gato gatoPosicion1 = (Gato)misAnimales[1];
        Gato gatoPosicion1 = (Gato)misAnimales[1];
        System.out.println("Gato recuperado ---> " + gatoPosicion1);
    }
    
}


class Animal {

    // SOBRESCRITURA DEL MÉTODO toString PARA INDICAR EL NOMBRE DE LA CLASE DEL OBJETO.
    @Override 
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Gato extends Animal {}

class Perro extends Animal {}