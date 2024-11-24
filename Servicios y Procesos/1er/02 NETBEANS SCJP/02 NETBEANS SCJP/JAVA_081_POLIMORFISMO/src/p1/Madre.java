// Crear una clase Madre que defina un atributo protegido x con valor 1.
// Generar un método igualmente protegido que nos indique cuánto vale dicha x.


package p1;

public class Madre {

    protected int x = 1;
    
    protected void dimeX() {
        System.out.println(x);
    }    
}
