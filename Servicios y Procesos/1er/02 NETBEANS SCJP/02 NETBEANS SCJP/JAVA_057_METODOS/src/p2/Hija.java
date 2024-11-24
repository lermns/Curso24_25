// Crear la clase Hija que extiende a la clase Madre. Tratar de sobrescribir el método final comer
// heredado de la Madre para comprobar como se genera un error de compilación.


package p2;

public class Hija extends MadreMetodoFinal {

    // ERROR, NO SE PUEDE SOBRESCRIBIR UN METODO FINAL.
    /*
    //@Override
    public void comer() {
        System.out.print("MI MADRE DICE ... ");
        super.comer();        
        System.out.println("PERO YO DIGO QUE COMO HAMBURGUESAS");        
    }
    */ 
    
    
    public static void main(String[] args) {
        
        new Hija().comer();        
    }    
}