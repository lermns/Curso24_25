// Crear una clase que haga uso de la estructura de sentencias if-else-if para 
// determinar qué gastos podemos realizar a la hora de por ejemplo, ir a ver
// una película al cine (... si es que podemos ir).

// En el momento que un if() se evalúa como válido, el resto ya no se hace (eficiencia).


package p4;

public class CondicionalIfElseIf {

    public static void main(String[] args) {
        
        int dinero = 10; // introducir sólo los valores {0 | 5 | 10 | 20}.
        
        System.out.println("DINERO = " + dinero + "\n");
        
        if(dinero == 5) {
            System.out.println("ME COMPRO PALOMITAS");
        } else if(dinero == 10) {
            System.out.println("ME COMPRO PALOMITAS Y UN BATIDO");
        } else if (dinero == 20) {
            System.out.println("ME COMPRO PALOMITAS, UN BATIDO Y LA ENTRADA DEL CINE");
        } else {
            System.out.println("HOY ME TOCA QUEDARME EN CASA");
        }        
    }    
}