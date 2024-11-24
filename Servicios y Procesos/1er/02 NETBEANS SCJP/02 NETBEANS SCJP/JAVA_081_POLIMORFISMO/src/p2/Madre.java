// Crear una clase Madre que defina 2 métodos m1 y m2. Se establece el código de
// m1 para que haga una llamada al método m2.


package p2;

public class Madre {

    // UN MÉTODO EN LA MADRE LLAMA A OTRO MÉTODO DE ELLA MISMA.
    protected void m1() {
        m2();
    }
    
    protected void m2() {
        System.out.println("SOY m2() DE MADRE");
    }    
}