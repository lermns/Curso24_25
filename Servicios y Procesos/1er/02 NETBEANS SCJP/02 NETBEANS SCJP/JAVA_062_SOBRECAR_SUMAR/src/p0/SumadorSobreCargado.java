// Crear una clase Sumador que aplique sobrecarga al método sumar(x,y). Así, se dispondrá
// de distintas formas de realizar la suma de 2 números en base a la naturaleza y posición
// de los argumentos de entrada (es lo que se busca con la sobrecarga, el disponer de
// distintas alternativas para poder realizar una determinada tarea).


package p0;

public class SumadorSobreCargado {

    // Tanto a la entrada cómo a la salida se admite autoBoxing/UnBoxing como
    // autoPromoción/Despromoción del los argumentos (no los 2 a la vez).
    
    public int sumar(int x, int y) { // int + int 
        System.out.println("sumar(int x, int y) " + (x + y));
        return x + y;
    }

    public Integer sumar(Integer x, Integer y) { // Integer + Integer.
        System.out.println("sumar(Integer x, Integer y) " + (x + y));        
        return x + y;
    }

    public double sumar(int x, Integer y) { // int + Integer.
        System.out.println("sumar(int x, Integer y) " + (x + y));        
        return x + y;
    }
    
    public double sumar(Integer x, int y) { // Integer + int.
        System.out.println("sumar(Integer x, int y) " + (x + y));                
        return x + y;
    }

    
    public static void main(String[] args) {
        
        SumadorSobreCargado sumador = new SumadorSobreCargado();
        
        sumador.sumar(5, 7);
        sumador.sumar(new Integer(5), Integer.valueOf(7));
        sumador.sumar(5, (Integer)7); // el 7 se convierte en el Wrapper Integer 7.
        sumador.sumar((Integer)5, 7);
        
        // orden de elección: primitivo -> Wrapper -> Number -> Object.
        
        // NO PUEDE HACERSE AUTOPROMOCIÓN + AUTOBOXING A LA VEZ.
        // UN CASTING DE WRAPPER SOBRE VALOR PRIMITIVO PROVOCA AUTOBOXING.
    }   
}