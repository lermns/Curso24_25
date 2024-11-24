// Crear una interfaz que defina los métodos más elementales que debe tener toda
// calculadora (establecer 2 parámetros de entrada de tipo double).

// Métodos sumar, restar, multiplicar y dividir (double x, double y).

package interfaces;

public interface InterfazCalcBasica {

    public double sumar(double x, double y);
    public double restar(double x, double y);
    public double multiplicar(double x, double y);
    public double dividir(double x, double y);    
}