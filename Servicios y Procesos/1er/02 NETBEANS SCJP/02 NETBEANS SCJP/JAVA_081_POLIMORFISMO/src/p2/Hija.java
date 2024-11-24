// Crear una clase Hija, que extendiente a la clase Madre, en la que se realiza
// la sobrescritura del método m2 heredado (m1 no se toca).


package p2;

public class Hija extends Madre {
   // m1 lo heredamos
   // m2 lo heredamos peeeeeero
    
    // SOBRESCRIBIMOS EL MÉTODO QUE ES LLAMADO EN LA MADRE.
    @Override
    protected void m2() {
        System.out.println("SOY m2() DE HIJA");
    }    
}