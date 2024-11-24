// Crear una clase que empleé distintas formas para crear un Wrapper a partir
// un primitivo y viceversa.


package p0;

public class ProcesosImplicitos {

    public static void main(String[] args) {
        
        int valorPrimitivo = 8;
        Integer objetoInteger = valorPrimitivo * 10; // AUTOBOXING.
        
        valorPrimitivo = objetoInteger; // AUTOUNBOXING.
        
        System.out.println("---> " + valorPrimitivo);
        System.out.println("---> " + objetoInteger);
        
        ///////////// AUTO-BOXING /////////////////////
        int x = 5;
        Integer w0 = x;
        
        Integer w1 = new Integer(5);
        Integer w2 = Integer.valueOf(x); // PARA CONVERTIR PRIMITIVO EN WRAPPER.
        Integer w3 = Integer.parseInt(String.valueOf(x)); // int a String y luego a Integer.
        
        System.out.println(w1); // toString();
        System.out.println(w2);
        System.out.println(w3);
        
        System.out.println("\n");
        
        ///////////// AUTO-UNBOXING /////////////////////        
        Integer z = new Integer(6); 
        int y0 = z;
        
        int y1 = z.intValue(); // PARA CONVERTIR WRAPPER EN PRIMITIVO.
        System.out.println(y1);        
    }    
}