// Mediante el uso de la clase java.lang.Math, crear una clase que defina métodos
// estáticos para realizar el cálculo de la raíz cuadrada, la potencia, el seno y
// el coseno de un determinado número ó números.

// Nota: definir un método cómo estático resulta interesante cuándo lo podemos 
// englobar en la categoria de "usar y tirar", es decir, cuándo le pasamos unos datos,
// nos devuelve un resultado y ahí se termina todo. Es lo mismo que decir que no 
// vamos a necesitar a continuación el objeto que supuestamente debimos crear
// para poder utilizar los métodos cuando estos eran de instancia (no estáticos).

// De esta forma nos ahorramos el repetitivo proceso asociado a la construcción y
// posterior destrucción del objeto (automático) y los recursos que ello consume.


package p0;

public class CalculadoraMath {
    
    public static void calcularRaizCuadrada(double numero) {
        System.out.println("LA RAIZ CUADRADA DE " + numero + " ES ..." +
                Math.sqrt(numero));
    }
        
    public static void calcularPotencia(double numero1, double numero2) {
        System.out.println(numero1 + " ELEVADO A " + numero2 + " ES ..." +
                Math.pow(numero1,numero2));
    }
    
    public static void calcularSeno(double numero) {
        System.out.println("EL SENO DE " + numero + " ES ..." +
                Math.sin(numero));
    }
    
    public static void calcularCoseno(double numero) {
        System.out.println("EL COSENO DE " + numero + " ES ..." +
                Math.cos(numero));
    }
}