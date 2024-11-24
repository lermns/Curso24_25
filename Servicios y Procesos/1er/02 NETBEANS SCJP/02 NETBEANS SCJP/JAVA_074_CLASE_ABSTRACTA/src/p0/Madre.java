// Crear una clase Madre que declare un método abstracto m1 (devuelve String) y una
// variable de tipo entero, ambos con encapsulación protected. A continuación, crear
// una subclase Hija que implemente dicho método abstracto, obteniéndose a través de
// éste el valor de la x heredada. Definir los constructores necesarios para realizar
// la inicialización de la variable a través de encadenamiento y de forma directa.
// Comprobar cómo han de seguirse las reglas de la sobrescritura y la imposibilidad
// de instanciar objetos de la clase Madre.


package p0;

public abstract class Madre {

    protected int x = 1; // El encapsulador por excelencia para usar herencia.
   
    protected Madre() {} // constructor encapsulado como protected para encadenar.
    
    protected Madre(int x) { // sobrecarga de constructores.
        this.x = x;
    }
    
    protected abstract String m1(); // método abstracto y protected.

}