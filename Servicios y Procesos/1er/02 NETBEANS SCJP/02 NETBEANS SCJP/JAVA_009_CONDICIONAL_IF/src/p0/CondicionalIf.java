// Crear una clase que compruebe el funcionamiento de la sentencia de control
// condicional if.


package p0;

public class CondicionalIf {

    public static void main(String[] args) {
        
        if(true) {
            System.out.println("LA CONDICION ES CIERTA");
            System.out.println("PORQUE TENEMOS UN true");
        }
        
        System.out.println("\n\n");
        
        if(false) {
            System.out.println("LA CONDICION ES FALSA");
            System.out.println("PORQUE TENEMOS UN false");
        }else{
            System.out.println("entramos obligatoriamente en el else");
        }
              
        boolean verdadero = false;
        
        if(verdadero) { // no usar la forma if(verdadero == true) ... ya es boolean.
            System.out.println("SE HACE ...");
        }
                
        final boolean falso = false;
        
        System.out.println("\n\n");        
        
        if(!falso) {
            System.out.println("ATENCION ... LA CONDICION HA RESULTADO FALSA");
        }
             
        //int dinero = 0; // ámbito global al método.
        boolean ingresoBancario = true;
        
        if(ingresoBancario) {
            int dinero = 0; // ámbito local al método.
            dinero += 2000; //dinero=dinero+2000;
        }
                
        System.out.println("TOTAL DINERO = " + dinero);
    }    
}