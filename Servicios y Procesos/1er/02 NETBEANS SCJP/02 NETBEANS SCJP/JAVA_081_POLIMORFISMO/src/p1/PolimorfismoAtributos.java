// Crear una clase que compruebe la diferencia de comportamiento del sistema de
// cara a herencia y polimorfismo, al utilizar métodos que actúan sobre variables
// declaradas en la clase madre, en el supuesto de tener o no esas mismas variables
// definidas en la clase hija (mismo nombre en ambas).


package p1;

public class PolimorfismoAtributos {

    public static void main(String[] args) {

        Hija h = new Hija();
        System.out.println(h.x);  
         System.out.println("--------------------------------------");
         h.dimeX();


        System.out.println("--- IGUAL SI USAMOS REFERENCIA DE MADRE CON OBJETO HIJA ---");
        
        Madre m = new Hija();
        m.dimeX(); // es método de instancia, luego polimórfico (lazy-binding).                
    }
}