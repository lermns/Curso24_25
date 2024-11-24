// Crear una clase que compruebe el funcionamiento de la anterior calculadora y su
// conjunto de métodos estáticos. Utilizar la referencia de la clase directamente en
// lugar de constituir un objeto para poder llamar a los métodos.


package p0;

public class PruebaCalculadora {

    public static void main(String[] args) {
        
        CalculadoraMath.calcularRaizCuadrada(100);
        
        CalculadoraMath.calcularPotencia(2,3);
        
        CalculadoraMath.calcularSeno(180);
        
        CalculadoraMath.calcularCoseno(0);   
    }   
}