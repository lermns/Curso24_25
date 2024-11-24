// Crear una clase que disponga de un método estático devolverEntero que retorne
// el valor 1. Dicho método se llamará directamente desde el main imprimiéndose
// por pantalla el valor devuelto.


package p1;

public class MetodoEstatico {

    public static int devolverEntero() {
        
        if(true) {
            return 1;
        }

        return 0;        
    }
    
    
    public static void main(String[] args) {
        
        System.out.println(devolverEntero());   
    }   
}