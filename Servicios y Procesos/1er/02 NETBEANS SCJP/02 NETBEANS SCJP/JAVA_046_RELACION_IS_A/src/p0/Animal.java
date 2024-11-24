// Crear en el mismo fichero las clases Animal, Gato, Perro (estas 2 últimas extienden
// a Animal) y la clase Mesa. Cargar una referencia de tipo Animal con objetos de tipo
// Gato y Perro (polimorfismo - UpCasting) para a continuación y usando el operador
// instanceof (comprueba el tipo de dato al que apunta la referencia), asignar dicha
// referencia Animal a una referencia de tipo Gato o Perro según indique el citado
// operador a través de su valor de devolución booleano (hay que forzar casting y el
// uso de instanceof nos indica cuál será el adecuado).

// Sobrescribir el método toString() en la clase madre (Animal) para que nos indique
// de qué naturaleza es el objeto actual. Así la versión sobrescrita se propaga a las 
// hijas, superponiéndose a la versión original que se sigue heredando de Object.


package p0;


public class Animal {

    @Override
    public String toString() {
        return "ES UN ... " + getClass().getSimpleName();
    }
}

class Gato extends Animal {}

class Perro extends Animal {}

class Mesa {}



class PruebaCasting {

    public static void main(String[] args) {
        
        Animal animal = new Gato(); // CORRECTO PORQUE GATO IS-A ANIMAL.
        
        //Animal animal = new Perro(); // CORRECTO PORQUE PERRO IS-A ANIMAL.
        
        /*
        if(animal instanceof Gato) { // DE QUÉ NATURALEZA ES EL OBJETO APUNTADO POR LA REFERENCIA.
            Gato unGato = (Gato)animal;
            System.out.println(unGato);
        } else {      
            Perro unPerro = (Perro)animal;
            System.out.println(unPerro);
        }
        */
        
        Gato g = (Gato)animal; //dará un classCastException
        System.out.println(g);
    }   
}