// Crear una clase en la que se demuestre el funcionamiento del género en Java. Hacer uso de los
// modificadores ?, extends y super, comprobando cómo según el tipo de modificador utilizado se
// pueden o no añadir nuevos elementos y el tipo de los mismos.


package p0;

import java.util.ArrayList;


public class Animal {
    
    @Override
    public String toString() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class Gato extends Animal {}

class Perro extends Animal {}



class Prueba {

    public static void main(String[] args) {
        
        ArrayList misAnimales1 = new ArrayList();        // colección sin género.        
        misAnimales1.add(new Animal());                  // permite mezcolanza de tipos.
        misAnimales1.add(new Gato());                    // Gato y Perro no son compatibles.
        misAnimales1.add(new Perro());
        
        System.out.println(misAnimales1);                // se llama al toString de cada objeto.

        
        
        // NO SE ADMITE POLIMORFISMO EN LA MARCA DE GÉNERO. USAR EL COMODÍN ?.
        // Error, se requiere <Animal>, <Gato> no sirve directamente:
        // ArrayList<Animal> misAnimales2 = new ArrayList<Gato>();        
        
        
        // ÉSTA ES LA FORMA HABITUAL DE DEFINIR EL GENÉRICO:
        ArrayList<Animal> misAnimales2 = new ArrayList<Animal>();
        misAnimales2.add(new Animal());                  // permite mezcolanza de tipos Animal.
        misAnimales2.add(new Gato());                    // Gato y Perro son también Animal.
        misAnimales2.add(new Perro());
        
        System.out.println(misAnimales2);
        
        
        
        // COLECCIONES HOMOGENEAS ... AÑADIR TIPO O SUBTIPO DEL INDICADO POR EL  <GÉNERO>:
        ArrayList<Gato> misAnimales3 = new ArrayList<Gato>(); // requiere Gato o subtipo.
        // misAnimales3.add(new Animal());              // error, Animal no es Gato.
        misAnimales3.add(new Gato());                   // correcto.
        //misAnimales3.add(new Perro());                // error, Perro no es Gato.
        
        System.out.println(misAnimales3);
        
        
        
        // Correcto, ? admite cualquier género, pero no se pueden añadir nuevos.        
        ArrayList<?> misAnimales4 = new ArrayList<Object>();
        // error, Animal es Object pero no se me permite añadir a la colección porque usarse <?>.
        //misAnimales4.add(new Animal());
        
        
        
        // Correcto, ? extends Animal, permite género Animal y subtipos de éste. 
        ArrayList<? extends Animal> misAnimales5 = new ArrayList<Gato>();
        //misAnimales5.add(new Gato()); //error, Gato es Animal pero no se me permite añadir por usarse <? extends>.
        

        
        // Correcto, ? super Animal, permite género Animal o supertipo de éste.
        ArrayList<? super Animal> misAnimales6 = new ArrayList<Object>();
        misAnimales6.add(new Animal()); // correcto, puedo añadir Animal o subtipo.
        misAnimales6.add(new Gato());   // correcto, puedo añadir Gato porque es subtipo.
        misAnimales6.add(new Perro());  // correcto, puedo añadir Perro porque es subtipo.
        
        // No hay problema al mezclar Animal con Gato y con Perro ya que todos son Animal
        // y es ese precisamente el género de la presente colección.
        // Por otro lado, si Animal puede manejar a los 3 (A,G,P), una marca supertipo como
        // es Object también podrá. Lo que no podemos permitir es que existan en la colección
        // objetos no compatibles con Animal (Object si los podría manejar), ya que el género
        // original de la colección es precisamente Animal, no Object.

        // error, Object no es subtipo de Animal sino supertipo, luego no se puede añadir.
        //misAnimales6.add(new Object());
    }

}