// Crear una clase para comprobar cómo se produce la propagación de una determinada
// excepción a través de la línea de invocación de métodos m1-->m2-->m3 (generar error).
// Tratar de realizar la captura de la excepción a través de un bloque try-catch que
// contiene un tipo que no corresponde con la excepción generada en m3 (no cumple IS-A)
// para ver cómo no se realiza dicha captura pero si se ejecuta el finally que contiene
// el bloque.


package p1;

public class PropagarExcepcion {

    private static void m3() {
        System.out.println("EN M3");
        //throw new Exception(); // error, si no ponemos el if, dará unreachable statement
        
        if(true) { 
            System.out.println("VOY A LANZAR UNA EXCEPCION AssertionError ---> ");
            throw new AssertionError(); // NO COMPROBATIVA.
        }
        
        System.out.println("SI DESACTIVADA, EL CODIGO DE M3 CONTINUA CON NORMALIDAD");        
    }
    
    private static void m2() {
        System.out.println("EN M2");
        m3(); // invocar a m3.
    }
    
    private static void m1() {
        System.out.println("EN M1");
        m2(); // invocar a m2.
    }

    
    public static void main(String[] args) {
        
        try {
            m1(); // invocar a m1
            
        // LA EXCEPCIÓN DE TIPO AssertionError NO ES DEL TIPO QUE SE QUIERE CAPTURAR, LUEGO PASA.    
        } catch(ArrayIndexOutOfBoundsException a) { // capturar sólo este tipo.        
            System.out.println("HE CAPTURADO UNA EXCEPCION DEL TIPO " + a.getClass().getSimpleName());
        } finally { // haya o no excepción y se capture o no, finally siempre se ejecuta.
            System.out.println("SE HA PASADO POR EL FINALLY ... SE CORROMPERÁ LA APLICACIÓN");
        }
   
        System.out.println("\nMAIN TERMINA CON NORMALIDAD ... FIN DE IMPRESION\n");
    }   
}