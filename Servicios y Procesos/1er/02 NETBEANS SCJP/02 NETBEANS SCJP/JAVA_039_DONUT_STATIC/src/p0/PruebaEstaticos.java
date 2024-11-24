// Crear una clase que demuestre el funcionamiento de las variables definidas cómo
// estáticas, en comparación de aquellas que no lo son.


package p0;

public class PruebaEstaticos {

    private int x = 9;             // variable de instancia ... cada objeto la suya
    public static int y = 10;      // variable estatica ... la misma para todos los objetos (compartida).
    
    
    public void consultarVariables() {
        System.out.println("x vale = " + x);
        System.out.println("y vale = " + y);        
    }
    
    
    public static void main(String[] args) {
                
        
        System.out.println("x vale " + new PruebaEstaticos().x); // si pongo x solo, falla
        
        System.out.println("y vale " + y);
        
        System.out.println("\n___________________________________\n");
        
        new PruebaEstaticos().consultarVariables();
    }
    
}

/////////////////////////////////////////////////////////////////////////////////

class Intruso {

    public static void main(String[] args) {
        
        PruebaEstaticos pe = new PruebaEstaticos();
        
        // ERROR, ES PRIVADO:
        //System.out.println("x de PruebaEstaticos = " + pe.x);
        
        System.out.println("y de PruebaEstaticos = " + pe.y);
        System.out.println("y de PruebaEstaticos = " + new PruebaEstaticos().y);        
        System.out.println("y de PruebaEstaticos = " + PruebaEstaticos.y);
    }
    
}