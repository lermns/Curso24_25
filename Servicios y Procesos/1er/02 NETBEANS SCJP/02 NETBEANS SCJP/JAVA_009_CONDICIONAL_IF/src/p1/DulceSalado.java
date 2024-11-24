// Crear una clase que evalúe el sabor de un alimento mediante el condicional if.


package p1;

public class DulceSalado {

    public static void main(String[] args) {
        
        boolean sabor = true; // true ... dulce, false ... salado.
        //boolean sabor = false;              
        
        if(sabor) {
            System.out.println("EL SABOR ES DULCE");
        }
                        
        if(!sabor) {
            System.out.println("EL SABOR ES SALADO");        
        }
    }    
}