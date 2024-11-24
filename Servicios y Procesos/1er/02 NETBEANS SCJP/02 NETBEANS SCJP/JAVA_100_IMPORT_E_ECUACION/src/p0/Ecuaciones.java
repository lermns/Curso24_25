// Crear una clase que defina una serie de métodos estáticos para realizar el
// cálculo del area de un círculo, el volumen de una esfera, la energía asociada
// a un partícula en reposo y el peso de un cuerpo. Realizar la importación
// estática de la variable PI y el método pow (clase java.lang.Math) para poder
// llevar a cabo dichos cálculos. El argumento de los métodos será un tipo double.


package p0;

//import static Math.PI; // error, es necesario indicar el paquete java.lang.
import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Ecuaciones {

    private static final double g = 9.8; // m/s^2
    private static final double c = 30000000; // m/s    

    
    // MÉTODOS DEFINIDOS COMO ESTÁTICOS PARA SER IMPORTADOS.
    public static double calcularAreaCirculo(double radio) {
        return PI * pow(radio,2);
    }
    
    public static double calcularVolumenEsfera(double radio) {    
        return 4*PI*1/3 * pow(radio,3);
    }
        
    public static double calcularEnergiaAsociada(double masa) {    
        return masa * pow(c,2);
    }
    
    public static double calcularPeso(double masa) {    
        return masa * g;
    }
}