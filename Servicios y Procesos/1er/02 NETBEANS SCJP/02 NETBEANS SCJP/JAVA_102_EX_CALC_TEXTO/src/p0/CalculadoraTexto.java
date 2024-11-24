// Crear una clase que simule una calculadora para realizar la suma y división
// de 2 números de tipo double, introducidos como String. Utilizaremos la
// conversión ofrecida por el método parseDouble del wrapper Double. Si el dato
// introducido no puede ser convertido, se generará una NumberFormatExcepction
// la cual deberemos capturar e informar del error por pantalla, tras lo cual la
// aplicación terminará con normalidad (es un fin controlado, no corrupto).
// En el caso de que los datos sean correctos, se mostrará el resultado de la
// operación por pantalla. Prestar atención al hecho de que el divisor sea 0.


package p0;

public class CalculadoraTexto {

    private static double x;
    private static double y;
    
    private static double conversorTexto(String s) {
        double valorConvertido = 0;
        
        try {
            valorConvertido = Double.parseDouble(s);
        } catch(NumberFormatException nfe) {
            System.out.println("\nERROR EN LA CONVERSION DEL DATO " + s + " A NUMERO");
            System.out.println(nfe);
            System.out.println("\n");
            System.exit(0);
        }
        
        return valorConvertido;        
    }

    
    public static void sumar(String s1, String s2) {
        x = conversorTexto(s1);
        y = conversorTexto(s2);
        System.out.println("LA SUMA DE " + x + " CON " + y + " RESULTA " + (x+y) + "\n");
    }
    
   
    public static void dividir(String s1, String s2) {
        x = conversorTexto(s1);
        y = conversorTexto(s2);
        
        if(y == 0) {
            System.out.println("EL DIVISOR NO PUEDE SER 0 \n");
            //System.exit(0);
            return;
        }
        
        System.out.println("LA DIVISION DE " + x + " CON " + y + " RESULTA " + (x/y) + "\n");
    }    
}