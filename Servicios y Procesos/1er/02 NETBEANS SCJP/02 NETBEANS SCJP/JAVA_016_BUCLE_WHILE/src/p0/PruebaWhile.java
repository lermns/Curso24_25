// Crear una clase que compruebe el funcionamiento del bucle de control while.


package p0;

public class PruebaWhile {
    
    public static void main(String[] args) {

// ES BUCLE INFINITO ... EL CÓDIGO QUE LE SIGUE DARÍA UNREACHABLE STATEMENT.
// CON RESPECTO A LAS LÍNEAS QUE VIENEN DESPUÉS DEL while() {}
//        while(true) {
//            System.out.println("hola");
//        }
        
// ERROR DE COMPILACION POR UNREACHABLE STATEMENT EN EL PROPIO while.
//        while(false) {
//            System.out.println("Te voy a dar 2 millones");
//        }

        
        int veces = 1;
        //      1
        int contador1=0;
        int contador2=0;
        
        while(++veces <= 2) {           // while( 1<=2)
        //while(++veces <= 2) {         // while(2<=2)   
            System.out.println("Ejecucion numero -> "+ contador1 +"--"+contador2 +"  veces ->"+veces);
            contador1++;
            ++contador2;
        
        }
        
        System.out.println("veces: "+veces);
        System.out.println("Contador1: "+contador1);
        System.out.println("Contador2: "+contador2);
        
        System.out.println("\nFIN");
        
       
    }
}