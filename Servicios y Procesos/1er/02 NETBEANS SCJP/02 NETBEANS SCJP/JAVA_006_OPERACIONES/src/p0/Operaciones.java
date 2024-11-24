// Crear una clase que compruebe el funcionamiento manual y automático de la 
// promocion(manual y automática) y despromoción(siempre manual) de un tipo, como
// es por ejemplo byte, a otro superior como sería un int.


package p0;

public class Operaciones {

    public static void main(String[] args) {
        
        byte b = 5;
        System.out.println("b = " + b);
        
        // UPGRADING ... PROMOCIÓN A UN TIPO SUPERIOR (IMPOSIBLE LA PÉRDIDA DE PRECISIÓN).
        int x1 = b * 1000;          // AUTOMÁTICA.
        int x2 = (int)b;            // MANUAL.
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        
        
        //DOWNGRADING ... DESPROMOCIÓN A UN TIPO INFERIOR (POSIBLE PÉRDIDA PRECISIÓN).
        b = (byte)x1; // SIEMPRE MANUAL.
        System.out.println("b = " + b + " ... HEMOS PERDIDO EL 5000 DE x1");        
    }    
}